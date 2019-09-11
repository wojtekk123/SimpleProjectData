package com.myWBexample.SimpleProjectData.Dao;

import com.myWBexample.SimpleProjectData.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by wojtek on 30.08.2019.
 */
@Repository ("fakeDao")
public class fakePersonDataAccess implements PersonDao{

    private static ArrayList<Person> peoples = new ArrayList<>();



    @Override
    public int insertPerson(UUID id, Person person) {


        peoples.add(new Person(person.getName(),id));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return peoples;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {

        return peoples.stream()
                .filter(person -> person.getId().equals(id))
                .findAny();

    }

    @Override
    public int deletePersonById(UUID id) {

        Optional<Person> personToDelete = selectPersonById(id);

        if (personToDelete.isPresent()){
            peoples.remove(personToDelete.get());
        return 1;
        }


        return 0;


    }

    @Override
    public int updatePerson(UUID id, Person update) {

    return     selectPersonById(id).map(person1 -> {

           int indexOdPerss = peoples.indexOf(person1);
           if (indexOdPerss>=0){
               peoples.set(indexOdPerss,new Person(update.getName(),id));
               return 1;
           }
           return 0;

       })
               .orElse(0);
    }


}
