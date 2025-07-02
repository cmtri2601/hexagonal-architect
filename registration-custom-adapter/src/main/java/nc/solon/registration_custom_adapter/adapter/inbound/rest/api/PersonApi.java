package nc.solon.registration_custom_adapter.adapter.inbound.rest.api;

import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Person api.
 */
@RequestMapping("/api/v1/persons")
public interface PersonApi {
    /**
     * Create person response entity.
     *
     * @param personInDTO the person in dto
     * @return the response entity
     */
    @PostMapping
    ResponseEntity<PersonOutDTO> createPerson(@RequestBody PersonInDTO personInDTO);

    /**
     * Gets person by id.
     *
     * @param id the id
     * @return the person by id
     */
    @GetMapping("/{id}")
    ResponseEntity<PersonOutDTO> getPersonById(@PathVariable Long id);

    /**
     * Search persons.
     *
     * @return the searched persons
     */
    @GetMapping()
    ResponseEntity<List<PersonOutDTO>> search(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "asc") String sort);

    /**
     * Update person response entity.
     *
     * @param id          the id
     * @param personInDTO the person in dto
     * @return the response entity
     */
    @PutMapping("/{id}")
    ResponseEntity<PersonOutDTO> updatePerson(@PathVariable Long id, @RequestBody PersonInDTO personInDTO);

    /**
     * Delete person response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePerson(@PathVariable Long id);
}
