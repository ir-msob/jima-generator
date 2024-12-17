package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegration;
import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedobject.relatedintegration.BaseRelatedIntegrationCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RelatedIntegrationCrudService<DTO extends Dto & RelatedIntegrationContainer>
        extends BaseRelatedIntegrationCrudService<
        <%= idClassName %>
        , User
        , RelatedIntegration
        , RelatedIntegrationCriteria
        , RelatedIntegrationContainer
        , DTO
        > {

}