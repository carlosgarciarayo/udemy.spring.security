package udemy.spring.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import udemy.spring.security.repository.CustomerRepository;
import udemy.spring.security.service.CustomerUserDetails;


@Service
public class CustomerUserDetailsImpl implements CustomerUserDetails {


    private final CustomerRepository customerRepository;

    public CustomerUserDetailsImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username)
                .map(customer -> org.springframework.security.core.userdetails.User.builder()
                        .username(customer.getEmail())
                        .password(customer.getPwd())
                        .roles(customer.getRol())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }
}
