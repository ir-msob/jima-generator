package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.childdomain.service;

import com.example.myproject.common.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.contactmedium.ContactMedium;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.contactmedium.ContactMediumCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
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