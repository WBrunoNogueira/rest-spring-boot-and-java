package com.er.rest_spring_boot_and_java;


import com.er.rest_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private  final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all Peaple");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8 ; i++) {

            Person person = mockPerson (i);
            persons.add(person);
        }
        return  persons;
    }



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

        public Person create(Person person){
            logger.info("create one Person");
            return  person;
        }

        public void delete(String id){
            logger.info("Delete one Person");

        }
        public Person update(Person person){
            logger.info("updating one Person");
            return person;

        }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());  // cointer de ID, simular persistencia
        person.setFistName("Fistname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("male");
        return  person;
    }
}
