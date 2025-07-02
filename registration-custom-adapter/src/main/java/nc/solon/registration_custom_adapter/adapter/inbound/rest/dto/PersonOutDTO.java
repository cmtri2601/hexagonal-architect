package nc.solon.registration_custom_adapter.adapter.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Person out dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonOutDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String taxId;

    private BigDecimal taxDebt;
}
