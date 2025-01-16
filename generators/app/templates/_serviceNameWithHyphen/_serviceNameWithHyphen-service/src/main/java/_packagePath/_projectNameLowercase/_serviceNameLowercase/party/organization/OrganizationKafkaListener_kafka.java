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

@Component
@ConditionalOnOperation(operations = {SAVE, UPDATE_BY_ID, DELETE_BY_ID})
@Resource(value = Organization.DOMAIN_NAME_WITH_HYPHEN, type = ResourceType.KAFKA)
public class OrganizationKafkaListener extends PartyKafkaListener<Organization, OrganizationDto, OrganizationCriteria, OrganizationRepository, OrganizationService> {
    public static final String BASE_URI = ChannelUtil.getBaseChannel(OrganizationDto.class);

    protected OrganizationKafkaListener(UserService userService, OrganizationService service, ObjectMapper objectMapper, ConsumerFactory<String, String> consumerFactory, BaseAsyncClient asyncClient) {
        super(userService, service, objectMapper, consumerFactory, asyncClient);
    }

    @Override
    public TypeReference<ChannelMessage<User, CriteriaMessage<String, OrganizationCriteria>>> getCriteriaReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, PageableMessage<String, OrganizationCriteria>>> getCriteriaPageReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, PageMessage<String, OrganizationDto>>> getPageReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, JsonPatchMessage<String, OrganizationCriteria>>> getEditReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, DtoMessage<String, OrganizationDto>>> getDtoReferenceType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public TypeReference<ChannelMessage<User, DtosMessage<String, OrganizationDto>>> getDtosReferenceType() {
        return new TypeReference<>() {
        };
    }
}
