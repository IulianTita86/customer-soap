package simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.entity.Customer;
import simple.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        return customer;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public int updateCustomer(Customer customer) {
        int rowAffected = customerRepository.updateCustomer(customer.getName(),customer.getEmail());
        return rowAffected;
    }
}
