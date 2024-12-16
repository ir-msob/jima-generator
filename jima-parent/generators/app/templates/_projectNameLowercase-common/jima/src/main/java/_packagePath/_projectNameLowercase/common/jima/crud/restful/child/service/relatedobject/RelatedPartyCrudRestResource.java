package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import com.example.myproject.common.jima.crud.base.child.relatedobject.RelatedPartyCrudService;
import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedPartyContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedparty.RelatedPartyCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedparty.BaseRelatedPartyCrudRestResource;

public interface RelatedPartyCrudRestResource<DTO extends Dto & RelatedPartyContainer, S extends RelatedPartyCrudService<DTO>>
        extends BaseRelatedPartyCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedParty
        , RelatedPartyCriteria
        , RelatedPartyContainer
        , DTO
        , S> {

}