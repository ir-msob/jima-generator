package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.RelatedActionCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import ir.msob.jima.crud.api.restful.service.child.relatedaction.BaseRelatedActionCrudRestResource;

public interface RelatedActionCrudRestResource<
        DTO extends Dto,
        S extends RelatedActionCrudService<DTO>
        > extends
        BaseRelatedActionCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , RelatedAction
            , RelatedActionCriteria
            , S> {
}
