package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.operation;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.core.commons.domain.BaseCriteria;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;

public interface BeforeAfterDomainOperation<DTO extends BaseDto<<%= idClassName %>>, C extends BaseCriteria<<%= idClassName %>>>
        extends BaseBeforeAfterDomainOperation<<%= idClassName %>, User, DTO, C> {

}