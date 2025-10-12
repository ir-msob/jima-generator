package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.id.BaseIdService;
import ir.msob.jima.core.commons.operation.BaseBeforeAfterDomainOperation;
import ir.msob.jima.crud.service.domain.BeforeAfterComponent;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;

@Service
public class TaskService extends BaseTaskService<TaskRepository> {


    @Override
    public TaskDto toDto(Task process, User user) {
        return null;
    }

    @Override
    public Task toDomain(TaskDto dto, User user) {
        return null;
    }
}
