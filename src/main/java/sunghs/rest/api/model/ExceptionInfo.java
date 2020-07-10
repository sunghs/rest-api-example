package sunghs.rest.api.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionInfo {

    private HttpStatus code;

    private String cause;

    private String url;
}
