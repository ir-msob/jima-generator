package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.relatedobject.relateddomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.relatedobject.relateddomain.RelatedDomainCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents the filters that can be applied when searching for related domains.
 * It implements the RelatedDomainCriteria and provides filters for the related domain type, ID, role, and referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedDomainCriteria extends RelatedDomainCriteriaAbstract<<%= idClassName %>> {

}