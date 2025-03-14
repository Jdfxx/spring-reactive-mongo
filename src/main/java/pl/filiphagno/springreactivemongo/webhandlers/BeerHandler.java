package pl.filiphagno.springreactivemongo.webhandlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.filiphagno.springreactivemongo.domain.Beer;
import pl.filiphagno.springreactivemongo.model.BeerDTO;
import pl.filiphagno.springreactivemongo.services.BeerService;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class BeerHandler {
    private final BeerService beerService;

    public Mono<ServerResponse> listBeers(ServerRequest request) {
        return ServerResponse.ok()
                .body(beerService.listBeers(), Beer.class);
    }

    public Mono<ServerResponse> getBeerById(ServerRequest request) {
        return ServerResponse.ok()
                .body(beerService.getById(request.pathVariable("beerId")), BeerDTO.class);
    }

}
