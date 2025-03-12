package pl.filiphagno.springreactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.filiphagno.springreactivemongo.domain.Beer;

public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {
}
