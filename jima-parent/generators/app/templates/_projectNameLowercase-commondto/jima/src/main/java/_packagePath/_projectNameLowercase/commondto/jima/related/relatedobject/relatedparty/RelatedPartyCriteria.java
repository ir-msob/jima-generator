package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.related.relatedobject.relatedparty.RelatedPartyCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents the filters that can be applied when searching for related parties.
 * It implements the RelatedPartyCriteria and provides filters for the related party type, ID, role, and referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedPartyCriteria extends RelatedPartyCriteriaAbstract<<%= idClassName %>> {

}