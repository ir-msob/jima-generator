package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import org.springframework.stereotype.Repository;

@Repository
public class ProcessRepository extends BaseProcessRepository {

    public BaseProcessRepository(RuntimeService runtimeService, ProcessInstanceQueryBuilder queryBuilder) {
        super(runtimeService, queryBuilder);
    }
}

