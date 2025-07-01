package nc.solon.registration_custom_adapter.adapter.outbound.persistence.port;

import nc.solon.registration_custom_adapter.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonPort {
    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> findByTaxId(String taxId);
    List<Person> findAll();
    void deleteById(Long id);
}
