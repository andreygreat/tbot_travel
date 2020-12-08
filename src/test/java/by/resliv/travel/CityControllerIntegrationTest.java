package by.resliv.travel;

import by.resliv.travel.TravelApplicationIntegrationTests;
import by.resliv.travel.controllers.CityController;
import by.resliv.travel.entities.City;
import by.resliv.travel.services.CityService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
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
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"Mogilew info\",\"actual\":true}"));
    }

    @Test
    @SneakyThrows
    void getCities() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cities/"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @SneakyThrows
    void create() {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"Hamburg\", \"info\" : \"City in Germany\", \"actual\" : \"true\"}"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\" : 15, \"name\" : \"Hamburg\", \"info\" : \"City in Germany\", \"actual\" : \"true\"}"));
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
                .content("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"Mogilew City in Belarus\",\"actual\":true}"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Mogilew\",\"info\":\"Mogilew City in Belarus\",\"actual\":true}"));
    }

    @Test
    @SneakyThrows
    void deleteOk() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cities/20"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//                .andExpect(MockMvcResultMatchers.content().json(""));
    }

    @Test
    @SneakyThrows
    void deleteFail() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cities/20"))
//                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//                .andExpect(MockMvcResultMatchers.content().json(""));
    }
}