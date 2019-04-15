package com.lbs.service;


import com.lbs.dao.EnterpriseProductDao;
import com.lbs.entity.EnterpriseProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EnterpriseProductService {
    List<EnterpriseProduct> selectEnterpriseProduct();

}
