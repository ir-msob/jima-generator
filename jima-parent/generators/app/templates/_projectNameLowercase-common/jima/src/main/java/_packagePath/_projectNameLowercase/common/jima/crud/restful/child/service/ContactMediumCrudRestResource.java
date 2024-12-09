package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.ContactMediumCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.contactmedium.BaseContactMediumCrudRestResource;

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
