package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.shared.ResourceType;
import ir.msob.jima.core.commons.scope.Resource;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.domain.service.CrudRestResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import <%= criteriaClassPath %>;

@RestController
@RequestMapping(<%= domainClassName %>RestResource.BASE_URI)
@RequiredArgsConstructor
@Resource(value = "<%= domainClassName %>", type = ResourceType.RESTFUL)
public class <%= domainClassName %>RestResource extends CrudRestResource<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service> {
    public static final String BASE_URI = "/api/v1/<%= domainClassNameWithHyphen %>";
}
