package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.childdomain.service.relatedobject;

import com.example.myproject.common.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.relatedobject.relatedparty.RelatedPartyCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.relatedobject.relatedparty.BaseRelatedPartyCrudRestResource;

public abstract class RelatedPartyCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseRelatedPartyCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedParty
        , RelatedPartyCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public RelatedPartyCrudRestResource(S childService, UserService userService) {
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