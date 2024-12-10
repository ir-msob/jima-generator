package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedPartyCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedPartyCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedparty.BaseRelatedPartyCrudRestResource;

public interface RelatedPartyCrudRestResource<DTO extends Dto, S extends RelatedPartyCrudService<DTO>>
        extends BaseRelatedPartyCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , RelatedParty
        , RelatedPartyCriteria
        , S> {

}