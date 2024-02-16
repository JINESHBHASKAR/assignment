package com.test.assignment.service.Impl;

import com.test.assignment.dto.CustomerDto;
import com.test.assignment.exception.BusinessException;
import com.test.assignment.mapper.CustomerMapper;
import com.test.assignment.model.Customer;
import com.test.assignment.repository.CustomerRepository;
import com.test.assignment.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> fetchCustomerDetails() {
        List<Customer> customers = customerRepository.findAll();

        if(customers == null | customers.isEmpty() ){
            throw new BusinessException("Customer not found");
        }

        List<CustomerDto> customerDtoList = CustomerMapper.toDTOList(customers);

        return customerDtoList;
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer(customerDto);
        Optional<Customer> customerDetails = customerRepository.findByEmail(customer.getEmail());
        if(customerDetails.isPresent()){
            throw new BusinessException("Customer Already Registered");
        }
        customerRepository.save(customer);
    }
}
