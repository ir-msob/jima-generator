package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedPartyCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedPartyCriteria;
import ir.msob.jima.core.commons.security.BaseUserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import ir.msob.jima.crud.api.restful.service.related.relatedobject.relatedparty.BaseRelatedPartyCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface RelatedPartyCrudRestResource<
        DTO extends Dto,
        S extends RelatedPartyCrudService<DTO>
        > extends
        BaseRelatedPartyCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , RelatedParty
            , RelatedPartyCriteria
            , S> {
}
