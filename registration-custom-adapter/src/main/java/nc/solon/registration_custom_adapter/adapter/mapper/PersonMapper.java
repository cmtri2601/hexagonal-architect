package nc.solon.registration_custom_adapter.adapter.mapper;

import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonInDTO;
import nc.solon.registration_custom_adapter.adapter.inbound.rest.dto.PersonOutDTO;
import nc.solon.registration_custom_adapter.adapter.outbound.persistence.entity.PersonEntity;
import nc.solon.registration_custom_adapter.domain.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toDomain(PersonInDTO dto);
    PersonOutDTO toDto(Person domain);
    List<PersonOutDTO> toDto(List<Person> domains);
    Person toDomain(PersonEntity dto);
    PersonEntity toEntity(Person domain);
}
