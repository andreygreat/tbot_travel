package by.resliv.travel.services;


import by.resliv.travel.entities.City;
import by.resliv.travel.exceptions.BadRequestException;
import by.resliv.travel.repositories.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CityService {

    final private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String getCityInfo(String cityNAme) {
        Optional<City> city = cityRepository.findByNameIgnoreCase(cityNAme);
        if (city.isEmpty()) {
            String answer = "City \'" + cityNAme + "\' not found";
            log.info(answer);
            return answer;
        } else if (city.get().getInfo().trim().equals("")) {
            return "Not info for city " + city.get().getName();
        } else {
            return city.get().getName() + ": " + city.get().getInfo();
        }
    }

    public City getCityById(int id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return city.get();
        } else {
            throw new BadRequestException(HttpServletResponse.SC_NOT_FOUND,
                    "Not found city with id = " + id);
        }
    }

    public City create(City city) {
        if (cityRepository.findByNameIgnoreCase(city.getName()).isPresent()) {
            throw new BadRequestException(HttpServletResponse.SC_BAD_REQUEST,
                    "Duplicate name city");
        }
        return cityRepository.save(city);
    }

    public City update(Integer id, City city) {
        city.setId(id);
        return cityRepository.save(city);
    }

    public List<City> getAll(Pageable page) {
        return cityRepository.findAll(page).toList();
    }

    public void delete(int id) {
        if (cityRepository.findById(id).isEmpty()) {
            throw new BadRequestException(HttpServletResponse.SC_BAD_REQUEST,
                    "Not found city with id = " + id);
        } else {
            cityRepository.deleteById(id);
        }
    }

}
