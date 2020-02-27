package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.mongodb.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService _personService;

    @Autowired
    public  PersonController(PersonService personService){
        this._personService = personService;
    }

    @PostMapping
    public  void addPerson(@Valid @NonNull @RequestBody Person person){
        _personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return _personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return _personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        _personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate){
        _personService.updatePerson(id, personToUpdate);
    }
}
