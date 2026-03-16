package com.er.rest_spring_boot_and_java;


import com.er.rest_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private  final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one Person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());  // cointer de ID, simular persistencia
        person.setFistName("wenderson");
        person.setLastName("Nogueira");
        person.setAddress("Valparaizo GO");
        person.setGender("male");
        return  person;
    }
}
