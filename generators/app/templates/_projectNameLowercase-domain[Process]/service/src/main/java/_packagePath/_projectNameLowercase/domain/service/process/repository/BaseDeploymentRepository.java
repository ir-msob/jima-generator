package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.DeploymentQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiDeploymentRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.Deployment;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment.DeploymentCriteria;
import org.activiti.engine.RepositoryService;

public abstract class BaseDeploymentRepository extends BaseActivitiDeploymentRepository<Deployment, DeploymentCriteria> {


    protected BaseDeploymentRepository(RepositoryService repositoryService, DeploymentQueryBuilder queryBuilder) {
        super(repositoryService, queryBuilder);
    }
}
