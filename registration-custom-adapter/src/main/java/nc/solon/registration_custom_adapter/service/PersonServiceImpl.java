package nc.solon.registration_custom_adapter.service;

import lombok.RequiredArgsConstructor;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.port.PersonPort;
import nc.solon.registration_custom_adapter.domain.PaginationRequest;
import nc.solon.registration_custom_adapter.domain.PersonDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The type Person service.
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonPort personPort;

    @Override
    public PersonDomain create(PersonDomain personDomain) {
        // Example: generate taxId if null (business rule)
        if (personDomain.getTaxId() == null) {
            String generatedTaxId = String.valueOf(UUID.randomUUID());
            personDomain = new PersonDomain(
                    personDomain.getId(),
                    personDomain.getFirstName(),
                    personDomain.getLastName(),
                    personDomain.getDateOfBirth(),
                    generatedTaxId,
                    personDomain.getTaxDebt()
            );
        }
        return personPort.create(personDomain);
    }

    @Override
    public PersonDomain getById(Long id) {
        return personPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    @Override
    public List<PersonDomain> search(PaginationRequest paginationRequest) {
        return personPort.search(paginationRequest);
    }

    @Override
    public PersonDomain update(Long id, PersonDomain updatedPersonDomain) {
        PersonDomain existing = getById(id); // ensure exists
        PersonDomain merged = new PersonDomain(
                existing.getId(),
                updatedPersonDomain.getFirstName(),
                updatedPersonDomain.getLastName(),
                updatedPersonDomain.getDateOfBirth(),
                existing.getTaxId(), // taxId should not change
                updatedPersonDomain.getTaxDebt()
        );
        return personPort.update(merged);
    }

    @Override
    public void delete(Long id) {
        personPort.deleteById(id);
    }
}
