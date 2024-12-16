package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import com.example.myproject.common.jima.crud.base.child.relatedobject.RelatedDomainCrudService;
import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomain;
import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomainContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomainCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relateddomain.BaseRelatedDomainCrudRestResource;

public interface RelatedDomainCrudRestResource<DTO extends Dto & RelatedDomainContainer, S extends RelatedDomainCrudService<DTO>>
        extends BaseRelatedDomainCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedDomain
        , RelatedDomainCriteria
        , RelatedDomainContainer
        , DTO
        , S> {

}