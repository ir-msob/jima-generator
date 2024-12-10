package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedIntegrationCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedintegration.BaseRelatedIntegrationCrudRestResource;

public interface RelatedIntegrationCrudRestResource<DTO extends Dto, S extends RelatedIntegrationCrudService<DTO>>
        extends BaseRelatedIntegrationCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , RelatedIntegration
        , RelatedIntegrationCriteria
        , S> {

}