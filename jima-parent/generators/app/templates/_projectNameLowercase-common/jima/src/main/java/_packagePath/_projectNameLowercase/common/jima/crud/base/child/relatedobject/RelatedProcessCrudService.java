package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.relatedobject;

import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcess;
import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessContainer;
import com.example.myproject.commondto.jima.child.relatedobject.relatedprocess.RelatedProcessCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.relatedobject.relatedprocess.BaseRelatedProcessCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RelatedProcessCrudService<DTO extends Dto & RelatedProcessContainer>
        extends BaseRelatedProcessCrudService<
        <%= idClassName %>
        , User
        , RelatedProcess
        , RelatedProcessCriteria
        , RelatedProcessContainer
        , DTO
        > {

}