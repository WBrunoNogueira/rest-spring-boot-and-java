/*
* No Spring (e em aplicações Java MVC), o Model é a parte que representa os dados e as regras de negócio da aplicação.
Ele normalmente corresponde às entidades (objetos que mapeiam tabelas do banco de dados)
* ou estruturas que guardam/transportam informação.
*
*
* */

package com.er.rest_spring_boot_and_java.model;

public record Greeting(long id, String content) {
}
