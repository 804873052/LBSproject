package com.lbs.service;


import com.lbs.entity.Products;

import java.util.Date;
import java.util.List;

public interface ProductsService {
    public List<Products> selectItemNumber(int itemNumber);
    void deleteProduct(int itemNumber);     //根据number删除数据(删除企业)
    void addProduct(String enterpriseName, double pay, Date dueDate);   //插入数据（添加新企业）
}
