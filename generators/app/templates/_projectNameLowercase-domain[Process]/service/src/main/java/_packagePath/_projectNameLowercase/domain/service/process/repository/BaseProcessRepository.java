package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.ProcessInstanceQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiProcessRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.Process;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.ProcessCriteria;
import org.activiti.engine.RuntimeService;

public abstract class BaseProcessRepository extends BaseActivitiProcessRepository<Process, ProcessCriteria> {

    protected BaseProcessRepository(RuntimeService runtimeService, ProcessInstanceQueryBuilder queryBuilder) {
        super(runtimeService, queryBuilder);
    }
}
