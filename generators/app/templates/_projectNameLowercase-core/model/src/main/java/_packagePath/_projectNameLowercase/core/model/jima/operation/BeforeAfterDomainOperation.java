package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.operation;

import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;

public interface BeforeAfterDomainOperation<DTO extends Dto>, C extends Criteria>>
        extends BaseBeforeAfterDomainOperation<<%= idClassName %>, User, DTO, C> {

}