package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.service;

import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiTaskRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.Task;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.TaskCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTaskService<R extends BaseActivitiTaskRepository<Task, TaskCriteria>> implements ir.msob.jima.process.commons.service.BaseTaskService<User, Task, TaskDto, TaskCriteria, R> {

    @Autowired
    R repository;

    @Override
    public R getRepository() {
        return repository;
    }
}