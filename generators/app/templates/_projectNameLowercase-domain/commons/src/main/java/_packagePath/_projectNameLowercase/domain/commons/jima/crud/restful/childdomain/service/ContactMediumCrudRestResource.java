package <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.restful.childdomain.service;

import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.contactmedium.BaseContactMediumCrudRestResource;

public abstract class ContactMediumCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseContactMediumCrudRestResource<
        <%= idClassName %>
        , User
        , ContactMedium
        , ContactMediumCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public ContactMediumCrudRestResource(S childService, UserService userService) {
                this.childService = childService;
                this.userService = userService;
        }

        @Override
        public S getChildService() {
                return childService;
        }

        @Override
        public BaseUserService getUserService() {
                return userService;
        }
}