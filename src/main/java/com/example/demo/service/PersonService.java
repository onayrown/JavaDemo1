package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final IPersonRepository _personRepository;

    @Autowired
    public PersonService(@Qualifier("fakeRepository") IPersonRepository personRepository){
        this._personRepository = personRepository;
    }

    public  int addPerson(Person person){
        return _personRepository.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return _personRepository.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return _personRepository.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return _personRepository.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return _personRepository.updatePersonById(id, newPerson);
    }
}
