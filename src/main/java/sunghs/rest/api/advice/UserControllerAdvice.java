package sunghs.rest.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sunghs.rest.api.exception.UserException;
import sunghs.rest.api.model.ExceptionInfo;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice
@Slf4j
public class UserControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ExceptionInfo defaultHandler(HttpServletRequest request, Throwable t) {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        httpHeaders.setContentType(mediaType);

        ExceptionInfo info = new ExceptionInfo();
        info.setCause(t.getMessage());
        info.setCode(HttpStatus.FORBIDDEN);
        info.setUrl(request.getRequestURI());

        return info;
    }

    @ExceptionHandler(UserException.class)
    public ExceptionInfo userHandler(HttpServletRequest request, UserException u) {
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        httpHeaders.setContentType(mediaType);

        ExceptionInfo info = new ExceptionInfo();
        info.setCause(u.getMessage());
        info.setCode(HttpStatus.OK);
        info.setUrl(request.getRequestURI());

        return info;
    }
}
