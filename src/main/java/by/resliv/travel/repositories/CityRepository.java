package by.resliv.travel.repositories;

import by.resliv.travel.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByNameIgnoreCase(String cityName);
}
