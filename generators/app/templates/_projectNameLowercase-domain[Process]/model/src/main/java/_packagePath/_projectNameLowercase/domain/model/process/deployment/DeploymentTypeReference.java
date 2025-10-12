package <%= packagePath %>.<%= projectNameLowercase %>.domain.model.process.deployment;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.DtoTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface DeploymentTypeReference
        extends DtoTypeReference<DeploymentDto, DeploymentCriteria>
        , ChannelTypeReference<DeploymentDto, DeploymentCriteria> {

    @Override
    default TypeReference<PageResponse<DeploymentDto>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<DeploymentDto>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<DeploymentCriteria> getCriteriaReferenceType() {
        return new TypeReference<DeploymentCriteria>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<DeploymentDto> getDtoReferenceType() {
        return new TypeReference<DeploymentDto>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<String, DeploymentCriteria>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<String, DeploymentCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<String, DeploymentCriteria>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<String, DeploymentCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<String, DeploymentDto>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<String, DeploymentDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<String, DeploymentCriteria>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<String, DeploymentCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<String, DeploymentDto>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<String, DeploymentDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<String, DeploymentDto>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<String, DeploymentDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}