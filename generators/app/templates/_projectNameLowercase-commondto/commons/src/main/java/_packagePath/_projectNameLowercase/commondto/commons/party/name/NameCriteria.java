package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.party.name;

import com.fasterxml.jackson.annotation.JsonInclude;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.criteria.ChildCriteriaAbstract;
import ir.msob.jima.core.commons.filter.BaseFilters;
import ir.msob.jima.core.commons.filter.Filter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * The 'NameCriteria' class represents a set of filters for names.
 * It implements the 'BaseFilters' interface.
 * The class includes fields for type, language, name, fullName, firstName, middleName, lastName, prefix, suffix, and nickname filters, and getter and setter methods for these fields.
 * Each filter is represented as a 'Filter' object.
 * The class uses the 'JsonInclude' annotation to specify that null fields should not be included in the JSON representation of an instance.
 * It also includes a no-argument constructor.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NameCriteria extends ChildCriteriaAbstract<Name> {
    /**
     * The type filter of the name filters.
     */
    private Filter<String> type;

    /**
     * The language filter of the name filters.
     */
    private Filter<String> language;

    /**
     * The name filter of the name filters.
     */
    private Filter<String> name;

    /**
     * The full name filter of the name filters.
     */
    private Filter<String> fullName;

    /**
     * The first name filter of the name filters.
     */
    private Filter<String> firstName;

    /**
     * The middle name filter of the name filters.
     */
    private Filter<String> middleName;

    /**
     * The last name filter of the name filters.
     */
    private Filter<String> lastName;

    /**
     * The prefix filter of the name filters.
     */
    private Filter<String> prefix;

    /**
     * The suffix filter of the name filters.
     */
    private Filter<String> suffix;

    /**
     * The nickname filter of the name filters.
     */
    private Filter<String> nickname;

    @Override
    public boolean isMatching(Name childDomain) {
        if (!super.isMatching(childDomain)) {
            return false;
        }

        if (Filter.isMatching(this.getType(), childDomain.getType())) {
            return false;
        }
        if (Filter.isMatching(this.getLanguage(), childDomain.getLanguage())) {
            return false;
        }
        if (Filter.isMatching(this.getName(), childDomain.getName())) {
            return false;
        }
        if (Filter.isMatching(this.getFullName(), childDomain.getFullName())) {
            return false;
        }
        if (Filter.isMatching(this.getFirstName(), childDomain.getFirstName())) {
            return false;
        }
        if (Filter.isMatching(this.getMiddleName(), childDomain.getMiddleName())) {
            return false;
        }
        if (Filter.isMatching(this.getLastName(), childDomain.getLastName())) {
            return false;
        }
        if (Filter.isMatching(this.getPrefix(), childDomain.getPrefix())) {
            return false;
        }
        if (Filter.isMatching(this.getSuffix(), childDomain.getSuffix())) {
            return false;
        }
        return !Filter.isMatching(this.getNickname(), childDomain.getNickname());
    }
}