
/*
* Um Controller é como o "porteiro" da aplicação web no
* Spring: ele recebe os pedidos de entrada (requisições HTTP), chama quem precisa dentro do sistema (serviços, repositórios) e devolve uma resposta.
Quer que eu te mostre também como fica um Controller mais completo, com POST, PUT, DELETE e recebendo dados do cliente?
*
*
* */
package com.er.rest_spring_boot_and_java.controllers;

import com.er.rest_spring_boot_and_java.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController   // anotation para reconhercer a classe como um rest controler
public class GreetingControler {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/greeting?name=Leandro

    @RequestMapping("/greeting")  // anotation para reconhercer o metodo com ometodo rest
    public Greeting greeting(

            @RequestParam(value = "name", defaultValue = "Word")
            String name){

        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
