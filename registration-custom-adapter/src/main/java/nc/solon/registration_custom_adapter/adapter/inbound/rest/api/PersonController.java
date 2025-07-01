package nc.solon.registration_custom_adapter.adapter.inbound.rest.api;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import nc.solon.registration_custom_adapter.adapter.mapper.PersonMapper;
import nc.solon.registration_custom_adapter.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import nc.solon.registration_custom_adapter.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController implements PersonApi {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Override
    public ResponseEntity<PersonOutDTO> createPerson(PersonInDTO personInDTO) {
        Person person = personMapper.toDomain(personInDTO);
        PersonOutDTO personOutDTO = personMapper.toDto(personService.create(person));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<PersonOutDTO> getPersonById(Long id) {
        PersonOutDTO personOutDTO = personMapper.toDto(personService.getById(id));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<List<PersonOutDTO>> getAllPersons() {
        List<PersonOutDTO> personOutDTO = personMapper.toDto(personService.getAll());
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<PersonOutDTO> updatePerson(Long id, PersonInDTO personInDTO) {
        Person person = personMapper.toDomain(personInDTO);
        PersonOutDTO personOutDTO = personMapper.toDto(personService.update(id, person));
        return ResponseEntity.ok(personOutDTO);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
