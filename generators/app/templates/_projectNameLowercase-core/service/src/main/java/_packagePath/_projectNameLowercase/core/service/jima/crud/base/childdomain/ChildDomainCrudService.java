package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.childdomain;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;

public interface ChildDomainCrudService<DTO extends Dto>
        extends BaseChildDomainCrudService<String, User, DTO> {

}