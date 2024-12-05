package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relateddomain.RelatedDomainCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.related.relatedobject.relateddomain.BaseRelatedDomainCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface RelatedDomainCrudRestResource<
        DTO extends Dto,
        S extends RelatedDomainCrudService<DTO>
        > extends
        BaseRelatedDomainCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , RelatedDomain
            , RelatedDomainCriteria
            , S> {
}
