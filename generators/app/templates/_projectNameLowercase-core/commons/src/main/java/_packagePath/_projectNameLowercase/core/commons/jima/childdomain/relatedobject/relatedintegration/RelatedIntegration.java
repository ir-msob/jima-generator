package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedobject.relatedintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.relatedobject.relatedintegration.RelatedIntegrationAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a related integration with a type, an ID, a role, and a referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedIntegration extends RelatedIntegrationAbstract<<%= idClassName %>> {

}