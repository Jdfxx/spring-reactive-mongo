package pl.filiphagno.springreactivemongo.webrouters;

import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.filiphagno.springreactivemongo.webhandlers.BeerHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class BeerRouterConfig {

    public static final String BEER_PATH = "/api/v3/beer";
    public static final String BEER_PATH_ID = BEER_PATH+"/{beerId}";

    private final BeerHandler beerHandler;

    @Bean
    public GroupedOpenApi employeesOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = { "/employees/**" };
        return GroupedOpenApi.builder().group("employees")
                .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Beer API").version(appVersion)))
                .pathsToMatch(paths)
                .build();
    }


    @RouterOperations(
            {@RouterOperation(path = BEER_PATH, beanClass = BeerHandler.class, beanMethod = "listBeers"),
                    @RouterOperation(path = BEER_PATH_ID, beanClass = BeerHandler.class, beanMethod = "getBeerById"),
                    @RouterOperation(path = BEER_PATH, beanClass = BeerHandler.class, beanMethod = "createNewBeer"),
                    @RouterOperation(path = BEER_PATH_ID, beanClass = BeerHandler.class, beanMethod = "deleteBeerById")}
    )
    @Bean
    public RouterFunction<ServerResponse> beerRoutes() {
        return route()
                .GET(BEER_PATH, accept(APPLICATION_JSON), beerHandler::listBeers)
                .GET(BEER_PATH_ID, accept(APPLICATION_JSON), beerHandler::getBeerById)
                .POST(BEER_PATH, accept(APPLICATION_JSON), beerHandler::createNewBeer)
                .PUT(BEER_PATH_ID, accept(APPLICATION_JSON), beerHandler::updateBeerById)
                .PATCH(BEER_PATH_ID, accept(APPLICATION_JSON), beerHandler::patchBeerById)
                .DELETE(BEER_PATH_ID, accept(APPLICATION_JSON), beerHandler::deleteBeerById)
                .build();
    }
}
