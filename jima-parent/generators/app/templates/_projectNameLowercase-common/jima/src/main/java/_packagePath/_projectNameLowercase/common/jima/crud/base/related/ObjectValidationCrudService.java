package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.objectvalidation.BaseObjectValidationCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class ObjectValidationCrudService<DTO extends Dto>
        implements BaseObjectValidationCrudService<
            <%= idClassName %>
            , User
            , DTO
            , ObjectValidation
            , ObjectValidationCriteria> {

}
