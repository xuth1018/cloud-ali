package com.xx.cloud.elasticMapper;

import com.xx.cloud.elasticType.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductMapper extends ElasticsearchRepository<Product,Long> {

    List<Product> findByName(String name);

    Page<Product> findByName(String name, Pageable pageable);

    List<Product> findByName(String name, Sort sort);

}
