package wsb.homeless.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsb.homeless.model.Person;
import wsb.homeless.repository.PersonRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceIml implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }
}
