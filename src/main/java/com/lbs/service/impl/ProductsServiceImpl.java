package com.lbs.service.impl;

import com.lbs.dao.ProductsDao;
import com.lbs.entity.Products;
import com.lbs.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 记得要加@Service注解
 */
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsDao producrDao;
    @Override
    public List<Products> selectItemNumber(int itemNumber) {
        List<Products> list = producrDao.selectItemNumber(itemNumber);
        return list;
    }

    @Override
    public void deleteProduct(int itemNumber) {
        List<Products> list = selectItemNumber(itemNumber);
        if(list != null){
            producrDao.deleteProduct(itemNumber);
        }
    }

    @Override
    public void addProduct(String enterpriseName, double pay, Date dueDate) {
        producrDao.addProduct(enterpriseName,pay,dueDate);
    }
}
