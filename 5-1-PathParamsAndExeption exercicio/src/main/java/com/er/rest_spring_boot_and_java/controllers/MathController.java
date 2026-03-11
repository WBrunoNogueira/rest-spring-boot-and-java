package com.er.rest_spring_boot_and_java.controllers;


import com.er.rest_spring_boot_and_java.controllers.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math") // Define o path base para o controlador
public class MathController {

    @GetMapping(value = "/{operation}/{numberOne}/{numberTwo}")
    public Double calculator(
            @PathVariable String operation,
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        Double n1 = convertToDouble(numberOne);
        Double n2 = convertToDouble(numberTwo);

        switch (operation.toLowerCase()) {
            case "sum":
                return n1 + n2;

            case "subtract":
                return n1 - n2;

            case "divide":
                if (n2 == 0)
                    throw new UnsupportedMathOperationException("Division by zero is not allowed!");
                return n1 / n2;

            case "average":
                return (n1 + n2) / 2;

            default:
                throw new UnsupportedMathOperationException("Invalid operation!");
        }
    }
    //endpoint unico para o squareroot...
    @GetMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) {

        Double n = convertToDouble(number);

        if (n < 0)
            throw new UnsupportedMathOperationException("Square root of negative number is not allowed!");
        double result = Math.sqrt(n);
        return Math.round(result * 100.0) / 100.0; // redond
    }

    public  Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
        return Double.parseDouble(number);
    }
}
