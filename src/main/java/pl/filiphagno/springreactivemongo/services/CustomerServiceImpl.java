package pl.filiphagno.springreactivemongo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.filiphagno.springreactivemongo.mapper.CustomerMapper;
import pl.filiphagno.springreactivemongo.model.CustomerDTO;
import pl.filiphagno.springreactivemongo.repository.CustomerRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Mono<CustomerDTO> save (Mono<CustomerDTO> customerDTO) {
        return customerDTO.map(customerMapper::customerDtoToCustomer)
                .flatMap(customerRepository::save)
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> getById(String id) {
        return null;
    }
}
