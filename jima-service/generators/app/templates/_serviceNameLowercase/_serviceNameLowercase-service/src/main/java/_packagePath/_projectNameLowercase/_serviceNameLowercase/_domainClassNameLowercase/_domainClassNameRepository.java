package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.CrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import org.springframework.stereotype.Repository;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;

@Repository
public class <%= domainClassName %>Repository extends CrudRepository<<%= domainClassName %>, <%= criteriaClassName %>> {
    @Override
    public QueryBuilder criteria(QueryBuilder query, <%= criteriaClassName %> criteria, User user) {
        return super.criteria(query, criteria, user);
    }
}

