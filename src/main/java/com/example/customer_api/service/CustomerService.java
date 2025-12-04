package com.example.customer_api.service;

import com.example.customer_api.dto.CustomerRequestDTO;
import com.example.customer_api.dto.CustomerResponseDTO;
import com.example.customer_api.dto.CustomerUpdateDTO;
import com.example.customer_api.entity.Customer.CustomerStatus;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CustomerService {
    
    List<CustomerResponseDTO> getAllCustomers();
    
    CustomerResponseDTO getCustomerById(Long id);
    
    CustomerResponseDTO createCustomer(CustomerRequestDTO requestDTO);
    
    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO requestDTO);
    
    void deleteCustomer(Long id);
    
    List<CustomerResponseDTO> searchCustomers(String keyword);
    
    List<CustomerResponseDTO> getCustomersByStatus(CustomerStatus status);

    List<CustomerResponseDTO> advancedSearch(String name, String email, CustomerStatus  status);

    Page<CustomerResponseDTO> getAllCustomers(int page, int size);

    List<CustomerResponseDTO> getAllCustomers(Sort sort);

    Page<CustomerResponseDTO> getAllCustomers(int page, int size, Sort sort);

    CustomerResponseDTO partialUpdateCustomer(Long id, CustomerUpdateDTO updateDTO);


}
