package nc.solon.registration_custom_adapter.adapter.inbound.rest.api;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import nc.solon.registration_custom_adapter.adapter.mapper.PersonMapper;
import nc.solon.registration_custom_adapter.domain.PersonDomain;
import nc.solon.registration_custom_adapter.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Person controller.
 */
@RestController
@RequiredArgsConstructor
public class PersonController implements PersonApi {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Override
    public ResponseEntity<PersonOutDTO> createPerson(PersonInDTO personInDTO) {
        PersonDomain personDomain = personMapper.dtoToDomain(personInDTO);
        PersonOutDTO personOutDTO = personMapper.domainToDto(personService.create(personDomain));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<PersonOutDTO> getPersonById(Long id) {
        PersonOutDTO personOutDTO = personMapper.domainToDto(personService.getById(id));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<List<PersonOutDTO>> getAllPersons() {
        List<PersonOutDTO> personOutDTO = personMapper.domainToDto(personService.getAll());
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<PersonOutDTO> updatePerson(Long id, PersonInDTO personInDTO) {
        PersonDomain personDomain = personMapper.dtoToDomain(personInDTO);
        PersonOutDTO personOutDTO = personMapper.domainToDto(personService.update(id, personDomain));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
