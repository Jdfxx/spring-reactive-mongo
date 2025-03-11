package pl.filiphagno.springreactivemongo.mapper;

import org.mapstruct.Mapper;
import pl.filiphagno.springreactivemongo.domain.Beer;
import pl.filiphagno.springreactivemongo.model.BeerDTO;

@Mapper
public interface BeerMapper {

    BeerDTO beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDTO beerDTO);
}
