package com.myWBexample.SimpleProjectData.Api;

import com.myWBexample.SimpleProjectData.Model.Person;
import com.myWBexample.SimpleProjectData.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by wojtek on 30.08.2019.
 */
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController( PersonService personService) {
        this.personService = personService;
    }

@PostMapping
    public void addPerson (@RequestBody Person person){

        this.personService.addPerson(person);

    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();

    }
@GetMapping(path = "{id}")
    public Person getPersonByID (@PathVariable ("id") UUID id) {
        return personService.getPersonByID(id)
                .orElse(null);

    }
@DeleteMapping(path = "{id}")
    public void deletePers  (@PathVariable ("id") UUID id ){

        personService.deletePerson(id);

    }
@PutMapping (path = "{id}")
    public void updatePerson (@PathVariable("id") UUID id,
                              @RequestBody Person person){
        personService.updataPerson(id,person); 
    }

}
