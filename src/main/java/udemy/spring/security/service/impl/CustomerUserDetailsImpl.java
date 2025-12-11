package udemy.spring.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import udemy.spring.security.mappers.CustomerUserDetailsMapper;
import udemy.spring.security.repository.CustomerRepository;
import udemy.spring.security.service.CustomerUserDetails;


@Service
public class CustomerUserDetailsImpl implements CustomerUserDetails {

    private final CustomerRepository customerRepository;
    private final CustomerUserDetailsMapper customerUserDetailsMapper;

    public CustomerUserDetailsImpl(CustomerRepository customerRepository, CustomerUserDetailsMapper customerUserDetailsMapper) {
        this.customerRepository = customerRepository;
        this.customerUserDetailsMapper = customerUserDetailsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username)
                .map(customerUserDetailsMapper::toUserDetails)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + username)
                );
    }
}
