package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject.RelatedProcessCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess.RelatedProcess;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedprocess.BaseRelatedProcessCrudRestResource;

public interface RelatedProcessCrudRestResource<DTO extends Dto, S extends RelatedProcessCrudService<DTO>>
        extends BaseRelatedProcessCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , RelatedProcess
        , RelatedProcessCriteria
        , S> {

}