package simple.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import simple.entity.Customer;

import java.util.stream.Stream;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.name = :name WHERE c.email = :email")
    int updateCustomer(@Param("name") String name, @Param("email") String email);
}
