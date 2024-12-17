package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedPartyContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedPartyCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedobject.relatedparty.BaseRelatedPartyCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RelatedPartyCrudService<DTO extends Dto & RelatedPartyContainer>
        extends BaseRelatedPartyCrudService<
        <%= idClassName %>
        , User
        , RelatedParty
        , RelatedPartyCriteria
        , RelatedPartyContainer
        , DTO
        > {

}