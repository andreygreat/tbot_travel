package by.resliv.travel.converters;


import by.resliv.travel.dto.RequestCity;
import by.resliv.travel.entities.City;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestCityToCity  implements Converter<RequestCity, City> {
    @Override
    public City convert(RequestCity source) {
        return new City(source.getName(), source.getInfo());
    }
}
