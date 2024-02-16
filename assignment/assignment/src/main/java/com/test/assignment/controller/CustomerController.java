package com.test.assignment.controller;

import com.test.assignment.constants.AppConstants;
import com.test.assignment.dto.CustomerDto;
import com.test.assignment.dto.ResponseDto;
import com.test.assignment.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CustomerController {

    private ICustomerService customerService;

    @GetMapping("/test")
    public String getHome(){
        ModelAndView view = new ModelAndView("index");
        return "index" ;
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<CustomerDto>> fetchAccountDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.fetchCustomerDetails());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer( @Valid @RequestBody CustomerDto customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ResponseDto("404", bindingResult.getGlobalError().getDefaultMessage()));
        }

        customerService.createCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AppConstants.STATUS_201,AppConstants.MESSAGE_201));
    }

}
