package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.relatedobject.relatedprocess.RelatedProcessCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents the filters that can be applied when searching for related processes.
 * It implements the RelatedProcessCriteria and provides filters for the related process type, ID, role, and referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedProcessCriteria extends RelatedProcessCriteriaAbstract<<%= idClassName %>, RelatedProcess> {

}