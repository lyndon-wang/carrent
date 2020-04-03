package com.rent.carrentservice.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rent.carrentdal.entity.Customer;
import com.rent.carrentdal.mapper.CustomerMapper;
import com.rent.carrentservice.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lyndon
 * @version
 */
@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}

