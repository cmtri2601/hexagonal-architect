package nc.solon.registration_custom_adapter.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Domain model representing a Person.
 */
public class PersonDomain {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String taxId;
    private final BigDecimal taxDebt;

    /**
     * Instantiates a new Person domain.
     *
     * @param id          the id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param dateOfBirth the date of birth
     * @param taxId       the tax id
     * @param taxDebt     the tax debt
     */
    public PersonDomain(Long id, String firstName, String lastName, LocalDate dateOfBirth, String taxId, BigDecimal taxDebt) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required.");
        }
        if (dateOfBirth == null || !dateOfBirth.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth must be in the past.");
        }
        if (taxDebt == null || taxDebt.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Tax debt cannot be null or negative.");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.taxId = taxId;
        this.taxDebt = taxDebt;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets tax id.
     *
     * @return the tax id
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Gets tax debt.
     *
     * @return the tax debt
     */
    public BigDecimal getTaxDebt() {
        return taxDebt;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * With updated debt person domain.
     *
     * @param newDebt the new debt
     * @return the person domain
     */
    public PersonDomain withUpdatedDebt(BigDecimal newDebt) {
        return new PersonDomain(this.id, this.firstName, this.lastName, this.dateOfBirth, this.taxId, newDebt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDomain personDomain)) return false;
        return Objects.equals(id, personDomain.id) &&
                Objects.equals(taxId, personDomain.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxId);
    }
}
