package nc.solon.registration_custom_adapter.service;

import nc.solon.registration_custom_adapter.domain.PaginationRequest;
import nc.solon.registration_custom_adapter.domain.PersonDomain;

import java.util.List;

/**
 * The interface Person service.
 */
public interface PersonService {
    /**
     * Create person domain.
     *
     * @param personDomain the person domain
     * @return the person domain
     */
    PersonDomain create(PersonDomain personDomain);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    PersonDomain getById(Long id);

    /**
     * Search .
     *
     * @return search result
     */
    List<PersonDomain> search(PaginationRequest paginationRequest);

    /**
     * Update person domain.
     *
     * @param id           the id
     * @param personDomain the person domain
     * @return the person domain
     */
    PersonDomain update(Long id, PersonDomain personDomain);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);
}

