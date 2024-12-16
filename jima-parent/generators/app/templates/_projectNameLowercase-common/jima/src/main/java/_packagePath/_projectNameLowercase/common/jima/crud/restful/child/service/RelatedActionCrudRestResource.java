package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import com.example.myproject.common.jima.crud.base.child.RelatedActionCrudService;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedAction;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedActionContainer;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedActionCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedaction.BaseRelatedActionCrudRestResource;

public interface RelatedActionCrudRestResource<DTO extends Dto & RelatedActionContainer, S extends RelatedActionCrudService<DTO>>
        extends BaseRelatedActionCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedAction
        , RelatedActionCriteria
        , RelatedActionContainer
        , DTO
        , S> {

}