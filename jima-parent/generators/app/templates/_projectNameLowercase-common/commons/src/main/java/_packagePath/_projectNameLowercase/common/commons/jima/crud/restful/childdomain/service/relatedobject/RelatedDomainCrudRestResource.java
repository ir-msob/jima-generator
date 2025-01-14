package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service.relatedobject;

import com.example.myproject.common.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relateddomain.RelatedDomainCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.relatedobject.relateddomain.BaseRelatedDomainCrudRestResource;

public abstract class RelatedDomainCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseRelatedDomainCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedDomain
        , RelatedDomainCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public RelatedDomainCrudRestResource(S childService, UserService userService) {
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