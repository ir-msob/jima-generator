package ir.msob.manak.process.deployment;

import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.model.process.deployment.DeploymentDto;
import ir.msob.manak.domain.service.process.service.BaseDeploymentService;
import org.springframework.stereotype.Service;

@Service
public class DeploymentService extends BaseDeploymentService<DeploymentRepository> {

    @Override
    public DeploymentDto toDto(Deployment process, User user) {
        return null;
    }

    @Override
    public Deployment toDomain(DeploymentDto dto, User user) {
        return null;
    }
}
