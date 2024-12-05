package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.relatedobject.RelatedProcessCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedprocess.RelatedProcess;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedobject.relatedprocess.RelatedProcessCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.related.relatedobject.relatedprocess.BaseRelatedProcessCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface RelatedProcessCrudRestResource<
        DTO extends Dto,
        S extends RelatedProcessCrudService<DTO>
        > extends
        BaseRelatedProcessCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , RelatedProcess
            , RelatedProcessCriteria
            , S> {
}
