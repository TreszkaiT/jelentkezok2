package com.example.views.controller;

import com.example.exception.InvalidPersonException;
import com.example.exception.PersonNotFoundException;
import com.example.views.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Ha valami Contorller-ből kirepül egy Exception, akkor ez el tudja kapni, és lekezeli
 */

// Bean lesz így belőle, a Spring meg másrészt tudni fogja, hogy ő azért felelős, hogy Controlleres Exceptionokat kapjon el
@RestControllerAdvice(assignableTypes = PersonController.class)          // (assignableTypes = MovieController.class) :: e nélkül az összes Controller fájlért ő felel
public class PersonControllerAdvice {

    @ExceptionHandler(value = PersonNotFoundException.class)                                                 // Ebből tudja, hogy Exceptiont kell kezelnie;;  ő csak ezért felelős : MovieNotFoundException.class
    public ResponseEntity<Void> handlePersonNotFoundException(){
        return ResponseEntity.badRequest().build();                                                         // 404-es HTTP status code;   build() : üres response body-val
    }

   /* @ExceptionHandler(value = InvalidPersonException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPersonException(InvalidPersonException exception){      // az Exceptiont úgy kapom el, hogy ide beírom paraméterként
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);

    }*/
}
