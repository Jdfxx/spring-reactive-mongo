package pl.filiphagno.springreactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.filiphagno.springreactivemongo.domain.Beer;
import reactor.core.publisher.Mono;

public interface BeerRepository extends ReactiveMongoRepository<Beer, String> {

    Mono<Beer> findFirstByBeerName(String beerName);

}
