package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.service;

import ir.msob.jima.core.commons.file.BaseFileClient;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiDeploymentRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.Deployment;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.DeploymentCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.DeploymentDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDeploymentService<R extends BaseActivitiDeploymentRepository<Deployment, DeploymentCriteria>> implements ir.msob.jima.process.commons.service.BaseDeploymentService<User, Deployment, DeploymentDto, DeploymentCriteria, R> {

    @Autowired
    BaseFileClient baseFileClient;

    @Autowired
    R repository;

    @Override
    public BaseFileClient getFileClient() {
        return baseFileClient;
    }

    @Override
    public R getRepository() {
        return repository;
    }
}
