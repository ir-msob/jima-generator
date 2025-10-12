package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.restful.service;

import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.Task;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.restful.service.BaseTaskRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaskRestResource.BASE_URI)
@Resource(value = Task.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class TaskRestResource extends BaseTaskRestResource<TaskRepository, TaskService> {
    public static final String BASE_URI = "/api/v1/" + Task.DOMAIN_NAME_WITH_HYPHEN;

}
