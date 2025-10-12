package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ir.msob.jima.core.commons.operation.Operations.*;

@RestController
@RequestMapping(TaskRestResource.BASE_URI)
@Resource(value = Task.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class TaskRestResource implements BaseTaskRestResource<TaskService, TaskRepository> {
    public static final String BASE_URI = "/api/v1/" +Task.DOMAIN_NAME_WITH_HYPHEN;

    protected TaskRestResource(UserService userService, TaskService service) {
        super(userService, service);
    }
}
