package by.resliv.travel.controllers;

import by.resliv.travel.dto.CityDto;
import by.resliv.travel.dto.RequestCity;
import by.resliv.travel.entities.City;
import by.resliv.travel.services.CityService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private final CityService cityService;
    private final ConversionService conversionService;

    public CityController(CityService cityService, ConversionService conversionService) {
        this.cityService = cityService;
        this.conversionService = conversionService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityDto getCity(@PathVariable final int id) {
        return new CityDto(cityService.getCityById(id));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CityDto> getCities(Pageable page) {
        return cityService.getAll(page).stream()
                .map(CityDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto create(@RequestBody @Valid final RequestCity city) {
        return new CityDto(cityService.create(Objects.requireNonNull(conversionService.convert(city, City.class))));
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable final int id,
                       @RequestBody @Valid final RequestCity city,
                       HttpServletResponse response) {
        City newCity = cityService.update(id, Objects.requireNonNull(conversionService.convert(city, City.class)));
        if (newCity.getId() == id) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        return new CityDto(newCity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final int id) {
        cityService.delete(id);
    }
}
