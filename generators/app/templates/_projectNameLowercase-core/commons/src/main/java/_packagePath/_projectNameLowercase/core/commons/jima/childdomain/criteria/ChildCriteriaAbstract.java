package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.criteria;

import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.ChildDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.criteria.BaseChildCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ChildCriteriaAbstract<CHILD extends ChildDomain> extends BaseChildCriteriaAbstract<<%= idClassName %>, CHILD> implements ChildCriteria<CHILD> {

}