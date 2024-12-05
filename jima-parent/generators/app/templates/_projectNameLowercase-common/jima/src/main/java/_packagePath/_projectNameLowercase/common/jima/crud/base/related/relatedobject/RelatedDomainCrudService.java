package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relateddomain.RelatedDomainCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.relatedobject.relateddomain.BaseRelatedDomainCrudService;
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
