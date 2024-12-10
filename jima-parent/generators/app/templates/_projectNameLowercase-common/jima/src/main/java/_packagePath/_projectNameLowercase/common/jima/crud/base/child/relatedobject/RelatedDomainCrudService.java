package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relateddomain.RelatedDomainCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedobject.relateddomain.BaseRelatedDomainCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedDomainCrudService<DTO extends Dto>
        implements BaseRelatedDomainCrudService<
            <%= idClassName %>
            , User
            , DTO
            , RelatedDomain
            , RelatedDomainCriteria> {

}