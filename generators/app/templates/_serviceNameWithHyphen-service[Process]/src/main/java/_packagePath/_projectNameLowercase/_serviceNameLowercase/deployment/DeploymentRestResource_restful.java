package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.service.process.restful.service.BaseDeploymentRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DeploymentRestResource.BASE_URI)
@Resource(value = Deployment.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class DeploymentRestResource extends BaseDeploymentRestResource<DeploymentRepository, DeploymentService> {
    public static final String BASE_URI = "/api/v1/" + Deployment.DOMAIN_NAME_WITH_HYPHEN;

}