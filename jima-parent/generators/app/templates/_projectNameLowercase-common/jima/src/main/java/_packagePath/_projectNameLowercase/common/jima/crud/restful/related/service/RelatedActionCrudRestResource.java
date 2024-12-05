package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.RelatedActionCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedaction.RelatedActionCriteria;
import ir.msob.jima.core.commons.security.BaseUserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import ir.msob.jima.crud.api.restful.service.related.relatedaction.BaseRelatedActionCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

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
