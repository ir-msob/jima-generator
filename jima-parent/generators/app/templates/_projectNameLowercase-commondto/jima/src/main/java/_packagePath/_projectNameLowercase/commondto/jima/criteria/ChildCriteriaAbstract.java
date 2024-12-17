package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria;

import com.example.myproject.commondto.jima.child.Child;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.BaseChildCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ChildCriteriaAbstract<CHILD extends Child> extends BaseChildCriteriaAbstract<<%= idClassName %>, CHILD> implements ChildCriteria<CHILD> {

}