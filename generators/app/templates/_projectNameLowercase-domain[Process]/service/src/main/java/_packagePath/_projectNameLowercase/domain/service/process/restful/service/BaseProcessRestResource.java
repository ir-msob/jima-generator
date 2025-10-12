package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.restful.service;

import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.Process;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.restful.service.BaseProcessRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProcessRestResource.BASE_URI)
@Resource(value = Process.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.RESTFUL)
public class ProcessRestResource extends BaseProcessRestResource<ProcessRepository, ProcessService> {
    public static final String BASE_URI = "/api/v1/" + Process.DOMAIN_NAME_WITH_HYPHEN;

}