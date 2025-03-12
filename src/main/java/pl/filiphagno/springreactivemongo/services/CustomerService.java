package pl.filiphagno.springreactivemongo.services;


import pl.filiphagno.springreactivemongo.domain.Customer;
import pl.filiphagno.springreactivemongo.model.CustomerDTO;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<CustomerDTO> save(Mono<CustomerDTO> customer);

    Mono<CustomerDTO> getById(String id);

}
