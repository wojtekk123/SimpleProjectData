package com.myWBexample.SimpleProjectData.Service;

import com.myWBexample.SimpleProjectData.Dao.PersonDao;
import com.myWBexample.SimpleProjectData.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by wojtek on 30.08.2019.
 */
@Service
public class PersonService {

    //gain acces to dao class

    private final PersonDao personDao;

    @Autowired

    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;

    }


    public void addPerson (Person person){
        personDao.insertPerson(person);

    }
    public List<Person> getAllPeople (){
        return personDao.selectAllPeople();

    }

    public Optional<Person> getPersonByID(UUID id ) {

        return personDao.selectPersonById(id);

    }

    public int deletePerson (UUID id){
        return personDao.deletePersonById(id);

    }

    public int updataPerson (UUID id, Person person){

        return personDao.updatePerson(id,person);

    }


}
