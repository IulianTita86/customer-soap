package simple.service;


import simple.entity.Customer;

public interface ICustomerService {
    Customer getCustomerByEmail(String email);
    boolean addCustomer(Customer customer);
    int updateCustomer(Customer customer);
}
