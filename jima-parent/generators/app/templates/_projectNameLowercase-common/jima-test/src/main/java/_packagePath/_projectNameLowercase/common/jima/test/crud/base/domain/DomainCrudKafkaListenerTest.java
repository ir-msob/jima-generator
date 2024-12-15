package com.example.myproject.common.jima.test.crud.base.domain;

import com.example.myproject.common.jima.crud.base.domain.DomainCrudRepository;
import com.example.myproject.common.jima.crud.base.domain.DomainCrudService;
import com.example.myproject.commondto.jima.channel.ChannelTypeReference;
import com.example.myproject.commondto.jima.criteria.Criteria;
import com.example.myproject.commondto.jima.domain.Domain;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.beans.properties.JimaProperties;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.crud.api.kafka.client.ChannelUtil;
import ir.msob.jima.crud.api.kafka.test.domain.BaseDomainCrudKafkaListenerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public abstract class DomainCrudKafkaListenerTest<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>,
        DP extends DomainCrudDataProvider<D, DTO, C, R, S>>
        implements BaseDomainCrudKafkaListenerTest<String, User, D, DTO, C, QueryBuilder, R, S, DP>
        , ChannelTypeReference<DTO, C> {

    private final Duration sleepDuration = Duration.of(1, ChronoUnit.SECONDS);
    @Autowired
    private DP dataProvider;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ConsumerFactory<String, String> consumerFactory;
    @Autowired
    private JimaProperties jimaProperties;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;


    @Override
    public String prepareCallbackTopic() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String prepareTopic(String operation) {
        return ChannelUtil.getChannel(getDtoClass(), operation);
    }

    @Override
    public KafkaTemplate<String, String> getKafkaTemplate() {
        return kafkaTemplate;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public Duration getSleepDuration() {
        return sleepDuration;
    }

    @Override
    public ConsumerFactory<String, String> getConsumerFactory() {
        return consumerFactory;
    }

    @Override
    public DP getDataProvider() {
        return dataProvider;
    }

    @Override
    public JimaProperties getJimaProperties() {
        return jimaProperties;
    }

    @Override
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    @Override
    public User getSampleUser() {
        return getDataProvider().getSampleUser();
    }
}