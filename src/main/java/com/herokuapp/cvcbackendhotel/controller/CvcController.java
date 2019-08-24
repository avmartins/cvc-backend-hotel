package com.herokuapp.cvcbackendhotel.controller;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.herokuapp.cvcbackendhotel.exception.RecurseNotFoundException;
import com.herokuapp.cvcbackendhotel.exception.ResponseError;

@ControllerAdvice
public class CvcController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ RecurseNotFoundException.class })
    public ResponseEntity<Object> handleRecurseNotFoundException(RecurseNotFoundException ex, WebRequest request) {
        return this.throwException(ex, ex.getMensagemClient(), request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ UnknownHostException.class, SocketException.class })
    public ResponseEntity<Object> handleUnknownHostException(IOException ex, WebRequest request) {
        String mensageToClient = "Verifique sua conexão com a internet e tente novamente, caso esteja conectado favor comunicar ao administrador do sistema!";
        return this.throwException(ex instanceof UnknownHostException ? (UnknownHostException) ex : (SocketException) ex,
                mensageToClient, request, HttpStatus.EXPECTATION_FAILED);
    }

    private ResponseEntity<Object> throwException(Exception ex, String message, WebRequest request, HttpStatus status) {
        List<ResponseError> erros = Arrays.asList(new ResponseError(message, ExceptionUtils.getRootCauseMessage(ex)));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), status, request);
    }

}

