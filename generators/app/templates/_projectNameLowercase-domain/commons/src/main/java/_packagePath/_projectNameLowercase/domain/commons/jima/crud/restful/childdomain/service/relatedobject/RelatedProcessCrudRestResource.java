package <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.restful.childdomain.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedobject.relatedprocess.RelatedProcess;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.relatedobject.relatedprocess.RelatedProcessCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.relatedobject.relatedprocess.BaseRelatedProcessCrudRestResource;

public abstract class RelatedProcessCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseRelatedProcessCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedProcess
        , RelatedProcessCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public RelatedProcessCrudRestResource(S childService, UserService userService) {
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