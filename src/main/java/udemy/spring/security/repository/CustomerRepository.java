package udemy.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udemy.spring.security.entites.Customer;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer, BigInteger> {

    Optional<Customer> findByEmail(String email);
}
