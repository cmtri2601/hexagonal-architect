package nc.solon.registration_custom_adapter.adapter.inbound.rest.api;

import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/persons")
public interface PersonApi {
    @PostMapping
    ResponseEntity<PersonOutDTO> createPerson(@RequestBody PersonInDTO personInDTO);

    @GetMapping("/{id}")
    ResponseEntity<PersonOutDTO> getPersonById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<PersonOutDTO>> getAllPersons();

    @PutMapping("/{id}")
    ResponseEntity<PersonOutDTO> updatePerson(@PathVariable Long id, @RequestBody PersonInDTO personInDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePerson(@PathVariable Long id);
}
