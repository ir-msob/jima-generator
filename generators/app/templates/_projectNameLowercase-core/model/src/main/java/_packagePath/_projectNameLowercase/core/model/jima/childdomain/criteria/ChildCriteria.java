package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.criteria;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.ChildDomain;
import ir.msob.jima.core.commons.childdomain.criteria.BaseChildCriteria;

public interface ChildCriteria<CHILD extends ChildDomain> extends BaseChildCriteria<<%= idClassName %>, CHILD> {

}