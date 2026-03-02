package com.er.rest_spring_boot_and_java.controllers.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}