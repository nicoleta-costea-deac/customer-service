package com.nicoleta.customerservice.service;

import com.nicoleta.customerservice.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final List<CustomerDTO> customers;

    public CustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(
                CustomerDTO
                        .builder()
                        .id(UUID.fromString("0207b4a6-dad5-4bf4-ade5-4321d9c6a948"))
                        .name("John Doe")
                        .build()
        );
        customers.add(
                CustomerDTO
                        .builder()
                        .id(UUID.fromString("8f764594-4773-42e2-8ca7-1ffde581af29"))
                        .name("Jane Doe")
                        .build()
        );
        customers.add(CustomerDTO
                .builder()
                .id(UUID.fromString("8cdaf61f-e1eb-48d4-b0e5-356c54c4a366"))
                .name("Jasmine Smith")
                .build());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return customers
                .stream()
                .filter(customer -> customer.getId().equals(id)).findFirst();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customers;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customers.add(customerDTO);
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        int index = -1;
        for (CustomerDTO customer : customers) {
            if (customer.getId().equals(customerId)) {
                index = customers.indexOf(customer);
                break;
            }
        }
        if (index != -1) {
            customers.set(index, customerDTO);
        }

        return null;
    }
}
