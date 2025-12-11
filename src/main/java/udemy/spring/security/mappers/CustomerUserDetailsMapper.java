package udemy.spring.security.mappers;


import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import udemy.spring.security.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerUserDetailsMapper {

    default UserDetails toUserDetails(Customer customer) {
        return User.builder()
                .username(customer.getEmail())
                .password(customer.getPwd())
                .roles(customer.getRol())
                .build();
    }
}