package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relateddomain.RelatedDomain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.child.objectvalidation.BaseObjectValidationCrudService;
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
