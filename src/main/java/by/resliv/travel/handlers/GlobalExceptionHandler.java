package by.resliv.travel.handlers;

import by.resliv.travel.dto.ApiErrorDto;
import by.resliv.travel.exceptions.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ApiErrorDto badRequest(final BadRequestException e, HttpServletResponse response){
        response.setStatus(e.getStatusCode());
        return new ApiErrorDto(e.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    public ApiErrorDto dataAccessException(DataAccessException e, HttpServletResponse response){
        log.error("Data Base Error: " + e.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return new ApiErrorDto("Data Base Error: " + e.getMessage());
    }

}
