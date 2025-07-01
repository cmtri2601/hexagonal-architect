package nc.solon.registration_custom_adapter.service;

import nc.solon.registration_custom_adapter.domain.Person;

import java.util.List;

public interface PersonService {
    Person create(Person person);
    Person getById(Long id);
    List<Person> getAll();
    Person update(Long id, Person person);
    void delete(Long id);
}
