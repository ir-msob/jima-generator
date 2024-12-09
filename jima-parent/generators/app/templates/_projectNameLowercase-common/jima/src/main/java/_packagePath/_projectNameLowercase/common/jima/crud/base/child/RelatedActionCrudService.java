package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedPartyCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.child.relatedaction.BaseRelatedActionCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedActionCrudService<DTO extends Dto>
        implements BaseRelatedActionCrudService<
            <%= idClassName %>
            , User
            , DTO
            , RelatedAction
            , RelatedActionCriteria> {

}
