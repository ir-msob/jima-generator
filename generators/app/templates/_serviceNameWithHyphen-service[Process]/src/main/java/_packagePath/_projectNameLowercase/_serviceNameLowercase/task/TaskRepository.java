package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends BaseTaskRepository {

    public BaseTaskRepository(RuntimeService runtimeService, TaskInstanceQueryBuilder queryBuilder) {
        super(runtimeService, queryBuilder);
    }
}

