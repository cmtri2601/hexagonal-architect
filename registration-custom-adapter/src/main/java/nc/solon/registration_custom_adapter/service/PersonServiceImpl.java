package nc.solon.registration_custom_adapter.service;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.port.PersonPort;
import nc.solon.registration_custom_adapter.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonPort personPort;

    @Override
    public Person create(Person person) {
        // Example: generate taxId if null (business rule)
        if (person.getTaxId() == null) {
            String generatedTaxId = String.valueOf(UUID.randomUUID());
            person = new Person(
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getDateOfBirth(),
                    generatedTaxId,
                    person.getTaxDebt()
            );
        }
        return personPort.save(person);
    }

    @Override
    public Person getById(Long id) {
        return personPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    @Override
    public List<Person> getAll() {
        return personPort.findAll();
    }

    @Override
    public Person update(Long id, Person updatedPerson) {
        Person existing = getById(id); // ensure exists
        Person merged = new Person(
                existing.getId(),
                updatedPerson.getFirstName(),
                updatedPerson.getLastName(),
                updatedPerson.getDateOfBirth(),
                existing.getTaxId(), // taxId should not change
                updatedPerson.getTaxDebt()
        );
        return personPort.save(merged);
    }

    @Override
    public void delete(Long id) {
        personPort.deleteById(id);
    }
}
