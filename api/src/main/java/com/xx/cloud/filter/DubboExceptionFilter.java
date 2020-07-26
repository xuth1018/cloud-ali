package com.xx.cloud.filter;

import com.xx.cloud.exception.ServiceException;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.ListenableFilter;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.service.GenericException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Activate(group = CommonConstants.PROVIDER)
public class DubboExceptionFilter extends ListenableFilter {

    public DubboExceptionFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return null;
    }

    static class ExceptionListenerX extends ExceptionListener {
        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
            if(appResponse.hasException() && GenericException.class != invoker.getInterface()){
                Throwable throwable = appResponse.getException();
                if(throwable instanceof ServiceException){
                    return;
                }
                if(throwable instanceof ConstraintViolationException){
                    appResponse.setException(this.handleConstrainViolationException((ConstraintViolationException)throwable));
                    return;
                }
            }
            //其余类型父类处理
            super.onResponse(appResponse, invoker, invocation);
        }

        private ServiceException handleConstrainViolationException(ConstraintViolationException ex) {
            StringBuilder stringBuilder = new StringBuilder();
            for(ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()){
                if(stringBuilder.length() > 0){
                    stringBuilder.append(";");
                }
                stringBuilder.append(constraintViolation.getMessage());
            }
            return new ServiceException(com.xx.cloud.exception.ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR,stringBuilder.toString());
        }
    }

    static class ExceptionListener implements Listener {
        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {

        }

        @Override
        public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {

        }
    }

}
