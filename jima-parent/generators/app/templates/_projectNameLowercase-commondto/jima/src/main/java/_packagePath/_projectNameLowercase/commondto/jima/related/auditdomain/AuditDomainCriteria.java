package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.auditdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedPartyCriteria;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.related.auditdomain.AuditDomainCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedPartyCriteria;
/**
 * The {@code AuditDomainFiltersAbstract} class represents a set of filters for querying audit domains.
 * It includes filters for the related party ID, action date, and action type.
 * This class implements the {@code BaseFilters} interface and includes getter and setter methods for each filter.
 * Additionally, it provides a no-argument constructor and a {@code toString} method that calls the superclass's {@code toString} method.
 * The class utilizes the {@code JsonInclude} annotation to specify that null fields should not be included in the JSON representation of an instance.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditDomainCriteria extends AuditDomainCriteriaAbstract<<%= idClassName %>, RelatedParty, RelatedPartyCriteria, AuditDomain> {
}