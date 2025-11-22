package <%= packagePath %>.<%= projectNameLowercase %>.domain.service.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.TaskQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiTaskRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.Task;
import <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.task.TaskCriteria;
import org.activiti.engine.TaskService;

public abstract class BaseTaskRepository extends BaseActivitiTaskRepository<Task, TaskCriteria> {

    protected BaseTaskRepository(TaskService taskService, TaskQueryBuilder queryBuilder) {
        super(taskService, queryBuilder);
    }
}
