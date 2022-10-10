package br.com.williams.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.williams.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(Person.class.getName());

    public Person findById(String id) {

        logger.info("Finding one Person!");
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Williams");
        person.setLastName("Nascimento");
        person.setAdress("Recife - Pernambuco - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Searching all people!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAdress("Some address in Brazil " + i);
        person.setGender("Male ");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public void delete(String id){
        logger.info("Updating one person!");
    }
}
