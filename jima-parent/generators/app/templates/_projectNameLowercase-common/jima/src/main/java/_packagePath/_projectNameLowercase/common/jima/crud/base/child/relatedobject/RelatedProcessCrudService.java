package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegration;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedintegration.RelatedIntegrationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedParty;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedPartyCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess.RelatedProcess;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.child.relatedobject.relatedprocess.BaseRelatedProcessCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class RelatedProcessCrudService<DTO extends Dto>
        implements BaseRelatedProcessCrudService<
            <%= idClassName %>
            , User
            , DTO
            , RelatedProcess
            , RelatedProcessCriteria> {

}
