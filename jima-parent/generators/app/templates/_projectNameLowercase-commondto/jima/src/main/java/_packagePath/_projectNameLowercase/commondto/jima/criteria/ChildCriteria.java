package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria;

import com.example.myproject.commondto.jima.child.Child;
import ir.msob.jima.core.commons.child.BaseChildCriteria;

public interface ChildCriteria<CHILD extends Child> extends BaseChildCriteria<<%= idClassName %>, CHILD> {

}