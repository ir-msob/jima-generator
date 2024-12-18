package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.domain.service.write;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.restful.service.domain.write.BaseDeleteByIdDomainCrudRestResource;

public interface DeleteByIdDomainCrudRestResource<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseDeleteByIdDomainCrudRestResource<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

}