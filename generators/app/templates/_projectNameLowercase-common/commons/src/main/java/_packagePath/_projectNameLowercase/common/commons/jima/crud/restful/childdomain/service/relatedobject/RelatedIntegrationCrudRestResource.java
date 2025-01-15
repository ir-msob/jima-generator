package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service.relatedobject;

import com.example.myproject.common.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.relatedobject.relatedintegration.BaseRelatedIntegrationCrudRestResource;

public abstract class RelatedIntegrationCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseRelatedIntegrationCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedIntegration
        , RelatedIntegrationCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public RelatedIntegrationCrudRestResource(S childService, UserService userService) {
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