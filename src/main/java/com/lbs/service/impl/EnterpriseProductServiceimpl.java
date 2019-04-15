package com.lbs.service.impl;

import com.lbs.dao.EnterpriseProductDao;
import com.lbs.entity.EnterpriseProduct;
import com.lbs.service.EnterpriseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class EnterpriseProductServiceimpl implements EnterpriseProductService {
    @Autowired
    EnterpriseProductDao enterpriseProductDao;
    @Override
    public List<EnterpriseProduct> selectEnterpriseProduct() {
        List<EnterpriseProduct> list = enterpriseProductDao.selectEnterpriseProduct();
        return list;
    }
}
