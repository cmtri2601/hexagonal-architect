package nc.solon.registration_custom_adapter.adapter.outbound.persistence.repository;

import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
