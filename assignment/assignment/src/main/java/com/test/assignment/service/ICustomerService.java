package com.test.assignment.service;

import com.test.assignment.dto.CustomerDto;
import com.test.assignment.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<CustomerDto> fetchCustomerDetails();

    void createCustomer(CustomerDto customerDto);
}
