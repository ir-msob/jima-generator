package <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.childdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security.User;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;

public interface ChildDomainCrudService<DTO extends Dto>
        extends BaseChildDomainCrudService<String, User, DTO> {

}