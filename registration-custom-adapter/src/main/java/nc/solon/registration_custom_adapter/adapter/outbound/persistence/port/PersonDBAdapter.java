package nc.solon.registration_custom_adapter.adapter.outbound.persistence.port;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.mapper.PersonMapper;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.repository.PersonRepository;
import nc.solon.registration_custom_adapter.domain.PersonDomain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Person db adapter.
 */
@Component
@RequiredArgsConstructor
public class PersonDBAdapter implements PersonPort {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDomain create(PersonDomain personDomain) {
        PersonEntity entity = personMapper.domainToEntity(personDomain);
        PersonEntity saved = personRepository.save(entity);
        return personMapper.entityToDomain(saved);
    }

    @Override
    public PersonDomain update(PersonDomain personDomain) {
        PersonEntity entity = personMapper.domainToEntity(personDomain);
        PersonEntity saved = personRepository.save(entity);
        return personMapper.entityToDomain(saved);
    }

    @Override
    public Optional<PersonDomain> findById(Long id) {
        return personRepository.findById(id).map(personMapper::entityToDomain);
    }

    @Override
    public List<PersonDomain> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}