package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.relatedobject.relatedintegration.BaseRelatedIntegrationCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedIntegrationCrudService<DTO extends Dto>
        implements BaseRelatedIntegrationCrudService<
            <%= idClassName %>
            , User
            , DTO
            , RelatedIntegration
            , RelatedIntegrationCriteria> {

}
