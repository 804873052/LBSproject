package com.lbs.dao;


import com.lbs.entity.Products;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

@SqlResource("products")
public interface ProductsDao extends BaseMapper {
    List<Products> selectItemNumber(@Param("itemNumber") int itemNumber);
    void deleteProduct(@Param("itemNumber")int itemNumber);
    void addProduct(@Param("enterpriseName")String enterpriseName, @Param("pay") double pay, @Param("duedate")Date dueDate);
}
