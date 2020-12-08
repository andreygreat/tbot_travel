package by.resliv.travel.dto;

import by.resliv.travel.entities.City;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class CityDto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    private String info;

    public CityDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
        this.info = city.getInfo();
    }
}
