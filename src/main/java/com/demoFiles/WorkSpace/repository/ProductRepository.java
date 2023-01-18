package com.demoFiles.WorkSpace.repository;

import com.demoFiles.WorkSpace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {


}
