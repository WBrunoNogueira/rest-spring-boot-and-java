package com.er.rest_spring_boot_and_java.controllers;

import com.er.rest_spring_boot_and_java.controllers.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//calculator sum/subtraction/multiplication/division/ square
@RestController
@RequestMapping("/math") // Define o path base para o controlador
public class MathController {

    //http://localhost:8080/math/sum/3/8
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    //http://localhost:8080/subtraction/sum/3/8
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    //http://localhost:8080/subtraction/sum/3/8
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    //http://localhost:8080/subtraction/sum/3/8
    @RequestMapping(value = "/square/{numberOne}/{numberTwo}")
    public Double square(@PathVariable("numberOne") String numberOne,
                         @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return covertToDouble(numberOne) * covertToDouble(numberTwo) / 2;
    }

    //http://localhost:8080/subtraction/sum/3/8
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo)
            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return covertToDouble(numberOne) * covertToDouble(numberTwo) / 2;
    }

    //http://localhost:8080/subtraction/sum/3/8
    @RequestMapping(value = "/squareRoot/{numberOne}")
    public Double squareRoot(
            @PathVariable("numberOne") String numberOne
    )
            throws Exception {
        if (!isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(covertToDouble(numberOne));
    }


    //Input handling
    public static Double covertToDouble(String strNumber) throws IllegalArgumentException {

        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
