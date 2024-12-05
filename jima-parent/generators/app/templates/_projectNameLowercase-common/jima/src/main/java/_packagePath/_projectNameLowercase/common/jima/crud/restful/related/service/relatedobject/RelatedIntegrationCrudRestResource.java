package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedIntegrationCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.related.relatedobject.relatedintegration.BaseRelatedIntegrationCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface RelatedIntegrationCrudRestResource<
        DTO extends Dto,
        S extends RelatedIntegrationCrudService<DTO>
        > extends
        BaseRelatedIntegrationCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , RelatedIntegration
            , RelatedIntegrationCriteria
            , S> {
}
