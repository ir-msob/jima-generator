package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relateddomain.RelatedDomainCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relateddomain.BaseRelatedDomainCrudRestResource;

public interface RelatedDomainCrudRestResource<DTO extends Dto, S extends RelatedDomainCrudService<DTO>>
        extends BaseRelatedDomainCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , RelatedDomain
        , RelatedDomainCriteria
        , S> {

}