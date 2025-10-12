package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ir.msob.jima.core.commons.operation.Operations.*;

@RestController
@RequestMapping(ProcessRestResource.BASE_URI)
@Resource(value = Process.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class ProcessRestResource implements BaseProcessRestResource<ProcessService, ProcessRepository> {
    public static final String BASE_URI = "/api/v1/" +Process.DOMAIN_NAME_WITH_HYPHEN;

    protected ProcessRestResource(UserService userService, ProcessService service) {
        super(userService, service);
    }
}
