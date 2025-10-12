package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.restful.domain.service.write;

import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.crud.api.restful.service.domain.write.BaseSaveDomainCrudRestResource;

public interface SaveDomainCrudRestResource<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseSaveDomainCrudRestResource<<%= idClassName %>, User, D, DTO, C, R, S> {

}