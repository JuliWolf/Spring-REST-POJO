package com.rest.rest;

import com.rest.entity.Customer;
import com.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

  // autowire the CustomerService
  @Autowired
  private CustomerService customerService;

  // add mapping for Get /customers
  @GetMapping("/customers")
  public List<Customer> getCustomers () {
    return customerService.getCustomers();
  }

  // add mapping for GET /customers/{customerId}
  @GetMapping("/customers/{customerId}")
  public Customer getCustomer (@PathVariable int customerId) {
    Customer customer = customerService.getCustomer(customerId);

    if (customer == null) {
      throw new CustomerNotFoundException("Customer is not found - " + customerId);
    }

    return customer;
  }

}
