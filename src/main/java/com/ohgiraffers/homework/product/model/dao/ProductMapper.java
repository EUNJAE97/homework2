package com.ohgiraffers.homework.product.model.dao;

import com.ohgiraffers.homework.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDTO> findAllProduct();

    void registProduct(ProductDTO product);
}
