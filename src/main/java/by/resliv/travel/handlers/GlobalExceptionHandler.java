package by.resliv.travel.handlers;

import by.resliv.travel.dto.ApiErrorDto;
import by.resliv.travel.exception.BadRequestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ApiErrorDto setStatusCode(final BadRequestException e, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return new ApiErrorDto(e.getMessage());
    }
}
