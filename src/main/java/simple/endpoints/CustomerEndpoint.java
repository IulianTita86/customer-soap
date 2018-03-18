package simple.endpoints;

import io.spring.guides.gs_producing_web_service.AddOrUpdateCustomerRequest;
import io.spring.guides.gs_producing_web_service.AddOrUpdateCustomerResponse;
import io.spring.guides.gs_producing_web_service.CustomerInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import simple.entity.Customer;
import simple.service.ICustomerService;


@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private ICustomerService customerService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOrUpdateCustomerRequest")
    @ResponsePayload
    public AddOrUpdateCustomerResponse addOrUpdateCustomer(@RequestPayload AddOrUpdateCustomerRequest request){
        AddOrUpdateCustomerResponse response = new AddOrUpdateCustomerResponse();
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());

        Customer customerFound = customerService.getCustomerByEmail(customer.getEmail());
        if(customerFound == null){
            customerService.addCustomer(customer);
        } else {
            customerService.updateCustomer(customer);
        }

        CustomerInfo customerInfo = new CustomerInfo();
        BeanUtils.copyProperties(customerService.getCustomerByEmail(customer.getEmail()), customerInfo);
        response.setCustomerInfo(customerInfo);
        return response;
    }
}
