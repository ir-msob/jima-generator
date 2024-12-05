package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.domain.service;

import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.domain.BaseCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.CrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.CrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudRestResource<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends CrudRepository<D, C>,
        S extends CrudService<D, DTO, C, R>
        > implements BaseCrudRestResource<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

    private final UserService userService;
    private final S service;

    protected CrudRestResource(UserService userService, S service) {
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
