package com.lbs.dao;

import com.lbs.entity.EnterpriseProduct;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("enterpriseProduct")
public  interface EnterpriseProductDao extends BaseMapper {
    List<EnterpriseProduct> selectEnterpriseProduct();
}
