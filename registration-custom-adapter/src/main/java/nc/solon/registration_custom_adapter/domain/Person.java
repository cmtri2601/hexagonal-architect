package nc.solon.registration_custom_adapter.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Domain model representing a Person.
 */
public class Person {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String taxId;
    private final BigDecimal taxDebt;

    public Person(Long id, String firstName, String lastName, LocalDate dateOfBirth, String taxId, BigDecimal taxDebt) {
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

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTaxId() {
        return taxId;
    }

    public BigDecimal getTaxDebt() {
        return taxDebt;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public Person withUpdatedDebt(BigDecimal newDebt) {
        return new Person(this.id, this.firstName, this.lastName, this.dateOfBirth, this.taxId, newDebt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(taxId, person.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxId);
    }
}
