package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.kafka.domain.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.client.BaseAsyncClient;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.kafka.service.domain.BaseDomainCrudKafkaListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.ConsumerFactory;

public abstract class DomainCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > implements BaseDomainCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S>
        , ChannelTypeReference<DTO, C> {

    private final UserService userService;
    private final S service;
    private final ObjectMapper objectMapper;
    private final ConsumerFactory<String, String> consumerFactory;
    private final BaseAsyncClient asyncClient;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    protected DomainCrudKafkaListener(UserService userService, S service, ObjectMapper objectMapper, ConsumerFactory<String, String> consumerFactory, BaseAsyncClient asyncClient) {
        this.userService = userService;
        this.service = service;
        this.objectMapper = objectMapper;
        this.consumerFactory = consumerFactory;
        this.asyncClient = asyncClient;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public ConsumerFactory<String, String> getKafkaConsumerFactory() {
        return consumerFactory;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public BaseAsyncClient getAsyncClient() {
        return asyncClient;
    }

    @Override
    public BaseUserService getUserService() {
        return userService;
    }

    @Override
    public S getService() {
        return service;
    }

}