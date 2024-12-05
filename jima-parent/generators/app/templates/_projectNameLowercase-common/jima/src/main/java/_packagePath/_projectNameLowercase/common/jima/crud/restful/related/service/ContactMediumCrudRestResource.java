package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.ContactMediumCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.related.contactmedium.BaseContactMediumCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface ContactMediumCrudRestResource<
        DTO extends Dto,
        S extends ContactMediumCrudService<DTO>
        > extends
        BaseContactMediumCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , ContactMedium
            , ContactMediumCriteria
            , S> {
}
