package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.client.BaseAsyncClient;
import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import ir.msob.jima.crud.api.kafka.client.ChannelUtil;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.kafka.domain.service.DomainCrudKafkaListener;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.security.UserService;
import <%= domainClassPath %>;
import <%= criteriaClassPath %>;
import <%= dtoClassPath %>;
import <%= typeReferenceClassPath %>;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import static ir.msob.jima.core.commons.operation.Operations.*;

@Component
@ConditionalOnOperation(operations = {SAVE, UPDATE_BY_ID, DELETE_BY_ID})
@Resource(value = <%= domainClassName %>.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.KAFKA)
public class <%= domainClassName %>KafkaListener
        extends DomainCrudKafkaListener<<%= domainClassName %>, <%= dtoClassName %>, <%= criteriaClassName %>, <%= domainClassName %>Repository, <%= domainClassName %>Service>
        implements <%= domainClassName %>TypeReference {
    public static final String BASE_URI = ChannelUtil.getBaseChannel(<%= dtoClassName %>.class);

    protected <%= domainClassName %>KafkaListener(UserService userService, <%= domainClassName %>Service service, ObjectMapper objectMapper, ConsumerFactory<String, String> consumerFactory, BaseAsyncClient asyncClient) {
        super(userService, service, objectMapper, consumerFactory, asyncClient);
    }

}
