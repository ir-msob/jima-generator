package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.domain.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.restful.service.domain.BaseDomainCrudRestResource;

public abstract class DomainCrudRestResource<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > implements BaseDomainCrudRestResource<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

    private final UserService userService;
    private final S service;

    protected DomainCrudRestResource(UserService userService, S service) {
        this.userService = userService;
        this.service = service;
    }

    @Override
    public BaseUserService getUserService() {
        return userService;
    }

    @Override
    public S getService() {
        return service;
    }
}
