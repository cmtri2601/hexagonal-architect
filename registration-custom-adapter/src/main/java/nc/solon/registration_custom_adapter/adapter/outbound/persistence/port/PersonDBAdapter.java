package nc.solon.registration_custom_adapter.adapter.outbound.persistence.port;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.mapper.PersonMapper;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.repository.PersonRepository;
import nc.solon.registration_custom_adapter.domain.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonDBAdapter implements PersonPort {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Person save(Person person) {
        PersonEntity entity = personMapper.toEntity(person);
        PersonEntity saved = personRepository.save(entity);
        return personMapper.toDomain(saved);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id).map(personMapper::toDomain);
    }

    @Override
    public Optional<Person> findByTaxId(String taxId) {
        return personRepository.findByTaxId(taxId).map(personMapper::toDomain);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}