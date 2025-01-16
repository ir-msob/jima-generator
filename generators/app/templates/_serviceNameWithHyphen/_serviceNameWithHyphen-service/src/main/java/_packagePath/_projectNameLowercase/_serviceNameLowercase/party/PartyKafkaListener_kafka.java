package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.kafka.domain.service.DomainCrudKafkaListener;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import <%= criteriaClassPath %>;
import <%= domainClassPath %>;
import <%= dtoClassPath %>;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.client.BaseAsyncClient;
import ir.msob.jima.core.commons.operation.ConditionalOnOperation;
import ir.msob.jima.core.commons.resource.Resource;
import ir.msob.jima.core.commons.shared.ResourceType;
import ir.msob.jima.crud.api.kafka.client.ChannelUtil;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import static ir.msob.jima.core.commons.operation.Operations.*;

public class PartyKafkaListener<P extends Party, PDTO extends PartyDto, PC extends PartyCriteria, PR extends PartyRepository, PS extends PartyService> extends DomainCrudKafkaListener<P, PDTO, PC, PR, PS> {
    public static final String BASE_URI = ChannelUtil.getBaseChannel(PartyDto.class);

    protected PartyKafkaListener(UserService userService, PS service, ObjectMapper objectMapper, ConsumerFactory<String, String> consumerFactory, BaseAsyncClient asyncClient) {
        super(userService, service, objectMapper, consumerFactory, asyncClient);
    }
}