package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.ObjectValidationCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.objectvalidation.ObjectValidation;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.objectvalidation.ObjectValidationCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.objectvalidation.BaseObjectValidationCrudRestResource;

public interface ObjectValidationCrudRestResource<DTO extends Dto, S extends ObjectValidationCrudService<DTO>>
        extends BaseObjectValidationCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , ObjectValidation
        , ObjectValidationCriteria
        , S> {

}