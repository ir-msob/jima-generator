package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedPartyCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedaction.RelatedAction;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedaction.RelatedActionCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.relatedaction.BaseRelatedActionCrudService;
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
