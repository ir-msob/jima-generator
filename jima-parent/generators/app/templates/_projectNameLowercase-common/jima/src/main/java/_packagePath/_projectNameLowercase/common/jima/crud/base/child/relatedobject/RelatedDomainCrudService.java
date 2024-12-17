package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomain;
import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomainContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relateddomain.RelatedDomainCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedobject.relateddomain.BaseRelatedDomainCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RelatedDomainCrudService<DTO extends Dto & RelatedDomainContainer>
        extends BaseRelatedDomainCrudService<
        <%= idClassName %>
        , User
        , RelatedDomain
        , RelatedDomainCriteria
        , RelatedDomainContainer
        , DTO
        > {

}