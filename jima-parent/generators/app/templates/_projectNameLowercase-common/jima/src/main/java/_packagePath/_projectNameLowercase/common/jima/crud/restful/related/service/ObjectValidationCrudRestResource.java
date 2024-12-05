package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.ObjectValidationCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.related.objectvalidation.BaseObjectValidationCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface ObjectValidationCrudRestResource<
        DTO extends Dto,
        S extends ObjectValidationCrudService<DTO>
        > extends
        BaseObjectValidationCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , ObjectValidation
            , ObjectValidationCriteria
            , S> {
}
