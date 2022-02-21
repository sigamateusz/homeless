package wsb.homeless.service;

import wsb.homeless.model.Person;

import java.util.Optional;

public interface PersonService {
    Person add(Person person);

    Optional<Person> findById(int id);
}
