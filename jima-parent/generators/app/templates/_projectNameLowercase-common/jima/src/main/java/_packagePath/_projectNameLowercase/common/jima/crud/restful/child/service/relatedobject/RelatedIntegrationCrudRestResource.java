package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import com.example.myproject.common.jima.crud.base.child.relatedobject.RelatedIntegrationCrudService;
import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegration;
import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedintegration.BaseRelatedIntegrationCrudRestResource;

public interface RelatedIntegrationCrudRestResource<DTO extends Dto & RelatedIntegrationContainer, S extends RelatedIntegrationCrudService<DTO>>
        extends BaseRelatedIntegrationCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedIntegration
        , RelatedIntegrationCriteria
        , RelatedIntegrationContainer
        , DTO
        , S> {

}