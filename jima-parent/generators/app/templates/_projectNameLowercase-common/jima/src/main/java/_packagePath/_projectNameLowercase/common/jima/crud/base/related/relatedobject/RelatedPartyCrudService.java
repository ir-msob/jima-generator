package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedparty.RelatedPartyCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.relatedobject.relatedparty.BaseRelatedPartyCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedPartyCrudService<DTO extends Dto>
        implements BaseRelatedPartyCrudService<
            <%= idClassName %>
            , User
            , DTO
            , RelatedParty
            , RelatedPartyCriteria> {

}
