package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service.relatedobject;

import com.example.myproject.common.jima.crud.base.child.relatedobject.RelatedProcessCrudService;
import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcess;
import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.relatedobject.relatedprocess.BaseRelatedProcessCrudRestResource;

public interface RelatedProcessCrudRestResource<DTO extends Dto & RelatedProcessContainer, S extends RelatedProcessCrudService<DTO>>
        extends BaseRelatedProcessCrudRestResource<
        <%= idClassName %>
        , User
        , RelatedProcess
        , RelatedProcessCriteria
        , RelatedProcessContainer
        , DTO
        , S> {

}