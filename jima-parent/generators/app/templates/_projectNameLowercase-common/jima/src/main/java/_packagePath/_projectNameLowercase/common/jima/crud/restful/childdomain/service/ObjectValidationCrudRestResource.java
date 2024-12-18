package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.childdomain.service;

import com.example.myproject.common.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
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