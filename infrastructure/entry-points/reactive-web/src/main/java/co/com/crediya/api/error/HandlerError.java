package co.com.crediya.api.error;


import co.com.crediya.model.user.exception.ExceptionDuplicity;
import co.com.crediya.model.user.exception.ExceptionOutOfRangeDate;
import co.com.crediya.model.user.exception.ExceptionLengthValue;
import co.com.crediya.model.user.exception.ExcepcionSinDatos;
import co.com.crediya.model.user.exception.ExceptionInvalidValue;
import co.com.crediya.model.user.exception.ExceptionWithoutData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

//@ControllerAdvice
public class HandlerError extends ResponseEntityExceptionHandler {
    
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(HandlerError.class);

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public HandlerError() {
        CODIGOS_ESTADO.put(ExceptionLengthValue.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExceptionInvalidValue.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionSinDatos.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExceptionWithoutData.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExceptionDuplicity.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExceptionTechnical.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        CODIGOS_ESTADO.put(ExceptionOutOfRangeDate.class.getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR.value());


    }

    @ExceptionHandler(Exception.class)
    public final Mono<ResponseEntity<Error>> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resul;

        String nameException = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = CODIGOS_ESTADO.get(nameException);

        if (code != null) {
            Error error = new Error(nameException, message);
            resul = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            LOGGER_ERROR.error(nameException, exception);
            Error error = new Error(nameException, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resul = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return Mono.just(resul);
    }
    
    
    
}