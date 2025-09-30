package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedobject.relatedintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.relatedobject.relatedintegration.RelatedIntegrationCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents the filters that can be applied when searching for related integrations.
 * It implements the RelatedIntegrationCriteria and provides filters for the related integration type, ID, role, and referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedIntegrationCriteria extends RelatedIntegrationCriteriaAbstract<<%= idClassName %>, RelatedIntegration> {

}