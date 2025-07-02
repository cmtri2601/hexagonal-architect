package nc.solon.registration_custom_adapter.adapter.mapper;

import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import nc.solon.registration_custom_adapter.domain.PersonDomain;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Person mapper.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    /**
     * Dto to domain person domain.
     *
     * @param dto the dto
     * @return the person domain
     */
    PersonDomain dtoToDomain(PersonInDTO dto);

    /**
     * Domain to dto person out dto.
     *
     * @param domain the domain
     * @return the person out dto
     */
    PersonOutDTO domainToDto(PersonDomain domain);

    /**
     * Domain to dto list.
     *
     * @param domains the domains
     * @return the list
     */
    List<PersonOutDTO> domainToDto(List<PersonDomain> domains);

    /**
     * Entity to domain person domain.
     *
     * @param dto the dto
     * @return the person domain
     */
    PersonDomain entityToDomain(PersonEntity dto);

    /**
     * Domain to entity person entity.
     *
     * @param domain the domain
     * @return the person entity
     */
    PersonEntity domainToEntity(PersonDomain domain);
}
