package <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.restful.childdomain.service;

import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.objectvalidation.BaseObjectValidationCrudRestResource;

public abstract class ObjectValidationCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseObjectValidationCrudRestResource<
        <%= idClassName %>
        , User
        , ObjectValidation
        , ObjectValidationCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public ObjectValidationCrudRestResource(S childService, UserService userService) {
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