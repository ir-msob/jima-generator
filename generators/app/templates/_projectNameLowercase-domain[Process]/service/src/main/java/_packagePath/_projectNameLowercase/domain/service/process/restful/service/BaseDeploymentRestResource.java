package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.restful.service;

import ir.msob.jima.core.commons.security.BaseUserService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.Deployment;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.DeploymentCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.DeploymentDto;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.repository.BaseDeploymentRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.service.BaseDeploymentService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDeploymentRestResource<
        R extends BaseDeploymentRepository,
        S extends BaseDeploymentService<R>
        > implements ir.msob.jima.process.api.restful.service.rest.deployment.BaseDeploymentRestResource<User, Deployment, DeploymentDto, DeploymentCriteria, R, S> {

    @Autowired
    S service;

    @Autowired
    BaseUserService baseUserService;

    @Override
    public S getService() {
        return service;
    }

    @Override
    public BaseUserService getUserService() {
        return baseUserService;
    }
}