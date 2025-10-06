package <%= packagePath %>.<%= projectNameLowercase %>.domain.model.<%= serviceNameLowercase %>.<%= domainClassNameLowercase %>;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.DtoTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface RepositoryTypeReference
        extends DtoTypeReference<<%= dtoClassName %>, <%= criteriaClassName %>>
        , ChannelTypeReference<<%= dtoClassName %>, <%= criteriaClassName %>> {

    @Override
    default TypeReference<PageResponse<<%= dtoClassName %>>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<<%= dtoClassName %>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<<%= criteriaClassName %>> getCriteriaReferenceType() {
        return new TypeReference<<%= criteriaClassName %>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<<%= dtoClassName %>> getDtoReferenceType() {
        return new TypeReference<<%= dtoClassName %>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<<%= idClassName %>, <%= criteriaClassName %>>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<<%= idClassName %>, <%= criteriaClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<<%= idClassName %>, <%= criteriaClassName %>>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<<%= idClassName %>, <%= criteriaClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<<%= idClassName %>, <%= dtoClassName %>>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<<%= idClassName %>, <%= dtoClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<<%= idClassName %>, <%= criteriaClassName %>>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<<%= idClassName %>, <%= criteriaClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<<%= idClassName %>, <%= dtoClassName %>>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<<%= idClassName %>, <%= dtoClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<<%= idClassName %>, <%= dtoClassName %>>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<<%= idClassName %>, <%= dtoClassName %>>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}