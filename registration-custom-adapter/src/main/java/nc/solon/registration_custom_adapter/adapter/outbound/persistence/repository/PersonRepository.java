package nc.solon.registration_custom_adapter.adapter.outbound.persistence.repository;

import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    /**
     * Find by tax id optional.
     *
     * @param taxId the tax id
     * @return the optional
     */
    Optional<PersonEntity> findByTaxId(String taxId);

    /**
     * Find by name prefix and older than list.
     *
     * @param prefix       the prefix
     * @param maxBirthDate the max birth date
     * @return the list
     */
    @Query(
            "SELECT p FROM PersonEntity p "
                    + "WHERE (LOWER(p.firstName) LIKE LOWER(CONCAT(:prefix, '%')) "
                    + "   OR LOWER(p.lastName) LIKE LOWER(CONCAT(:prefix, '%'))) "
                    + "AND p.dateOfBirth <= :maxBirthDate")
    List<PersonEntity> findByNamePrefixAndOlderThan(
            @Param("prefix") String prefix, @Param("maxBirthDate") LocalDate maxBirthDate);
}
