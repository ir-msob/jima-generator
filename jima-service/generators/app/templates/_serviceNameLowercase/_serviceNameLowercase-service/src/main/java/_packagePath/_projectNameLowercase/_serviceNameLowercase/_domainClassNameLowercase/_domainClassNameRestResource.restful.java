package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.domain.service.DomainCrudRestResource;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(<%= domainClassName %>RestResource.BASE_URI)
@RequiredArgsConstructor
@Resource(value = "<%= domainClassName %>", type = ResourceType.RESTFUL)
public class <%= domainClassName %>RestResource extends DomainCrudRestResource<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service> {
    public static final String BASE_URI = "/api/v1/<%= domainClassNameWithHyphen %>";

    protected <%= domainClassName %>RestResource(UserService userService, <%= domainClassName %>Service service) {
        super(userService, service);
    }
}
