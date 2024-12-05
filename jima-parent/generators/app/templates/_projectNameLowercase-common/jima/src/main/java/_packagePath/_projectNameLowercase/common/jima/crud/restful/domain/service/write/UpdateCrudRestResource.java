package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.domain.service.write;

import ir.msob.jima.crud.api.restful.service.domain.write.BaseUpdateCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.CrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.CrudRepository;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;

public interface UpdateCrudRestResource<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends CrudRepository<D, C>,
        S extends CrudService<D, DTO, C, R>
        > extends BaseUpdateCrudRestResource<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

}