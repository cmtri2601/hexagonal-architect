package nc.solon.registration_custom_adapter.adapter.outbound.persistence.port;

import nc.solon.registration_custom_adapter.domain.PaginationRequest;
import nc.solon.registration_custom_adapter.domain.PersonDomain;

import java.util.List;
import java.util.Optional;

/**
 * The interface Person port.
 */
public interface PersonPort {
    /**
     * Create person domain.
     *
     * @param personDomain the person domain
     * @return the person domain
     */
    PersonDomain create(PersonDomain personDomain);

    /**
     * Update person domain.
     *
     * @param personDomain the person domain
     * @return the person domain
     */
    PersonDomain update(PersonDomain personDomain);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<PersonDomain> findById(Long id);

    /**
     * Search.
     *
     * @return the list
     */
    List<PersonDomain> search(PaginationRequest paginationRequest);


    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);
}
