package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.childdomain.service.relatedobject;

import com.example.myproject.common.jima.crud.base.childdomain.ChildDomainCrudService;
import com.example.myproject.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
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