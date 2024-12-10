package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.relatedaction.RelatedActionCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedActionCriteria extends RelatedActionCriteriaAbstract<<%= idClassName %>, RelatedAction> {

}