package pl.filiphagno.springreactivemongo.mapper;

import org.mapstruct.Mapper;
import pl.filiphagno.springreactivemongo.domain.Customer;
import pl.filiphagno.springreactivemongo.model.CustomerDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}