package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party.name;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.BaseChildDomainAbstract;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.ChildDomainAbstract;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a Name entity with various attributes.
 *
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name extends ChildDomainAbstract implements Comparable<Name> {

    @NotBlank
    private String type;

    @NotBlank
    private String language;

    private String name;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String prefix;
    private String suffix;
    private String nickname;

    /**
     * Constructs a new Name instance.
     *
     * @param id the identifier
     * @param parentId the parent identifier
     * @param name the name
     * @param fullName the full name
     * @param firstName the first name
     * @param lastName the last name
     * @param middleName the middle name
     * @param type the type
     * @param language the language
     * @param prefix the prefix
     * @param suffix the suffix
     * @param nickname the nickname
     */
    @Builder
    public Name(<%= idClassName %> id, <%= idClassName %> parentId, String type, String language, String name, String fullName, String firstName, String middleName, String lastName, String prefix, String suffix, String nickname) {
        super(id, parentId);
        this.type = type;
        this.language = language;
        this.name = name;
        this.fullName = fullName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.nickname = nickname;
    }

    /**
     * Checks if this Name is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Name name1 = (Name) o;
        return Objects.equals(name, name1.name) &&
                Objects.equals(fullName, name1.fullName) &&
                Objects.equals(firstName, name1.firstName) &&
                Objects.equals(lastName, name1.lastName) &&
                Objects.equals(middleName, name1.middleName) &&
                Objects.equals(type, name1.type) &&
                Objects.equals(language, name1.language) &&
                Objects.equals(prefix, name1.prefix) &&
                Objects.equals(suffix, name1.suffix) &&
                Objects.equals(nickname, name1.nickname);
    }

    /**
     * Computes the hash code for this Name.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, fullName, firstName, lastName, middleName, type, language, prefix, suffix, nickname);
    }

    /**
     * Compares this Name with another Name.
     *
     * @param o the other Name to compare with
     * @return a negative integer, zero, or a positive integer as this Name is less than, equal to, or greater than the specified Name
     */
    @Override
    public int compareTo(Name o) {
        if (this == o) {
            return 0;
        }

        if (o != null && (this.name != null && o.name != null)) {
            return this.name.compareTo(o.name);
        }

        return Comparator
                .comparing(System::identityHashCode)
                .compare(this, o);
    }

    /**
     * Enumeration of field names for the Name class.
     */
    public enum FN {
        name, fullName, firstName, lastName, middleName, type, language, prefix, suffix, nickname
    }
}