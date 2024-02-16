package com.test.assignment.mapper;

import com.test.assignment.dto.CustomerDto;
import com.test.assignment.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDto toDTO(Customer customer) {
        CustomerDto customerDTO = new CustomerDto();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName( customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAge(customer.getAge());
        return customerDTO;
    }


    public static Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName( customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setAge(customerDto.getAge());

        return customer;
    }


    public static List<CustomerDto> toDTOList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
