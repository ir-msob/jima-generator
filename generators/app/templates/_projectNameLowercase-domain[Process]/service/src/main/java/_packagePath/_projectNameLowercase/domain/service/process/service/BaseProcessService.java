package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.service;

import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiProcessRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.Process;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.ProcessCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.process.ProcessDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseProcessService<R extends BaseActivitiProcessRepository<Process, ProcessCriteria>> implements ir.msob.jima.process.commons.service.BaseProcessService<User, Process, ProcessDto, ProcessCriteria, R> {

    @Autowired
    R repository;

    @Override
    public R getRepository() {
        return repository;
    }

}
