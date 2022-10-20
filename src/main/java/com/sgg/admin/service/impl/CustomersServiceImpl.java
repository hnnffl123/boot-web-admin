package com.sgg.admin.service.impl;

import com.sgg.admin.bean.Customers;
import com.sgg.admin.mapper.CustomersMapper;
import com.sgg.admin.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangruiqing
 * @Description
 * @date 2022-10-12 19:52
 */
@Service
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    CustomersMapper customersMapper;
    
    public Customers getCustById(Long id){
        return customersMapper.getCust(id);
    }
    
}
