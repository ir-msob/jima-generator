package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import com.example.myproject.commondto.jima.child.relatedaction.RelatedAction;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedActionContainer;
import com.example.myproject.commondto.jima.child.relatedaction.RelatedActionCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedaction.BaseRelatedActionCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedActionCrudService<DTO extends Dto & RelatedActionContainer>
        implements BaseRelatedActionCrudService<
        <%= idClassName %>
        , User
        , RelatedAction
        , RelatedActionCriteria
        , RelatedActionContainer
        , DTO
        > {

}