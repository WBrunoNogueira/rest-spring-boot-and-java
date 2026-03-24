package com.er.rest_spring_boot_and_java.controllers;

import com.er.rest_spring_boot_and_java.PersonServices;
import com.er.rest_spring_boot_and_java.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    //injeção de dependencia atraves do notation
    @Autowired
    private PersonServices service;


    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 //CREATE
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create( @RequestBody Person person) {
        return service.create(person);

    }
    //UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@PathVariable("id") String id,
                         @RequestBody Person person) {
        return service.update(person);

    }
    //DELETE
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
