package com.lbs.controller;


import com.lbs.entity.EnterpriseProduct;
import com.lbs.entity.Products;
import com.lbs.service.EnterpriseProductService;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    SQLManager sqlManager;

    /**
     * 查询表products中的所有数据
     * @return
     */
    @RequestMapping("/products")
    public List<Products> CompaniesList(){
        Query<Products> query = sqlManager.query(Products.class);   //单表查询
        List<Products> list = query.select();
        System.out.println(list);
        return list;
    }

    /**
     * 删除单条数据,(根据编号)
     */
    public void deleteProduct(int itemNumber){

    }

    /**
     * 查询enterprise Product
     */
    @Autowired
    EnterpriseProductService enterpriseProductService;

    @GetMapping("/enterpriseProduct")
    public List<EnterpriseProduct> selectEP(){
        return enterpriseProductService.selectEnterpriseProduct();
    }
}
