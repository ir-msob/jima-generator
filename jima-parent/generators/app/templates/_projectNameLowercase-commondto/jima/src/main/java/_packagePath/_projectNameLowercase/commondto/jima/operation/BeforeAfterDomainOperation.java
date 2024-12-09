package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.operation;

import ir.msob.jima.core.commons.criteria.BaseCriteria;
import ir.msob.jima.core.commons.dto.BaseDto;
import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
public interface BeforeAfterDomainOperation<DTO extends BaseDto<<%= idClassName %>>, C extends BaseCriteria<<%= idClassName %>>>
        extends BaseBeforeAfterDomainOperation<<%= idClassName %>, User, DTO, C> {
}