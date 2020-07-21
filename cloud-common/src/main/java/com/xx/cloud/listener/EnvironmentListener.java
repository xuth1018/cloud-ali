package com.xx.cloud.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentListener implements ApplicationListener<EnvironmentChangeEvent> {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent environmentChangeEvent) {

    }
}
