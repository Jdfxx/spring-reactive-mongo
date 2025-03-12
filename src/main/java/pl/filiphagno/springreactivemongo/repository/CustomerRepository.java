package pl.filiphagno.springreactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.filiphagno.springreactivemongo.domain.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
