package by.resliv.travel;

import by.resliv.travel.controllers.CityController;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
class CityControllerIntegrationTest extends TravelApplicationIntegrationTests {

    @Autowired
    private CityController cityService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void getCity() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"Mogilew info\"}"));
    }

    @Test
    @SneakyThrows
    void getCities() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"name\":\"Mogilew\",\"info\":\"Mogilew info\"},{\"id\":2,\"name\":\"Moscow\",\"info\":\"Capital of Russia\"},{\"id\":3,\"name\":\"Minsk\",\"info\":\"Capital of Belarus\"},{\"id\":4,\"name\":\"Grodno\",\"info\":\"Grodno info\"},{\"id\":5,\"name\":\"Brest\",\"info\":\"Brest info\"}]"));
    }

    @Test
    @SneakyThrows
    void create() {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"Hamburg\", \"info\" : \"City in Germany\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\" : 6, \"name\" : \"Hamburg\", \"info\" : \"City in Germany\"}"));
    }

    @Test
    @SneakyThrows
    void createDuplicateName() {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Mogilew\",\"info\":\"Mogilew City in Belarus\",\"actual\":true}"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void update() {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/cities/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"City in Belarus\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"City in Belarus\"}"));
    }

    @Test
    @SneakyThrows
    void deleteOk() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cities/5"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @SneakyThrows
    void deleteFail() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cities/20"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}