package ir.msob.manak.process.deployment;

import ir.msob.jima.process.ral.activiti.beans.query.DeploymentQueryBuilder;
import ir.msob.manak.domain.service.process.repository.BaseDeploymentRepository;
import org.activiti.engine.RepositoryService;
import org.springframework.stereotype.Repository;

@Repository
public class DeploymentRepository extends BaseDeploymentRepository {

    public DeploymentRepository(RepositoryService repositoryService, DeploymentQueryBuilder queryBuilder) {
        super(repositoryService, queryBuilder);
    }
}

