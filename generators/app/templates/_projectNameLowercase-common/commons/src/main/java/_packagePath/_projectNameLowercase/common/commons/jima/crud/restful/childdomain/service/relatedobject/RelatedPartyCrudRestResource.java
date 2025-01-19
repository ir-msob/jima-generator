package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relatedparty.RelatedPartyCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
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