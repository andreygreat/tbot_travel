package by.resliv.travel.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RequestCity {
    @NotNull
    private String name;
    private String info;
}
