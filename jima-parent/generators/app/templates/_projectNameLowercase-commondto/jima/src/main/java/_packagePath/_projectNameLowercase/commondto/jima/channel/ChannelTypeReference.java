package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.channel;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.BaseChannelTypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.IdJsonPatchMessage;
import ir.msob.jima.core.commons.channel.message.IdMessage;
import ir.msob.jima.core.commons.channel.message.IdsMessage;
import ir.msob.jima.core.commons.channel.message.LongMessage;
import ir.msob.jima.core.commons.dto.ModelType;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
public interface ChannelTypeReference<DTO extends Dto, C extends Criteria> extends BaseChannelTypeReference<<%= idClassName %>, User, DTO, C> {
    default TypeReference<ChannelMessage<User, ModelType>> getModelTypeReferenceType() {
        return new TypeReference<ChannelMessage<User, ModelType>>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdMessage<String>>> getIdReferenceType() {
        return new TypeReference<ChannelMessage<User, IdMessage<String>>>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdsMessage<String>>> getIdsReferenceType() {
        return new TypeReference<ChannelMessage<User, IdsMessage<String>>>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdJsonPatchMessage<String>>> getIdJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, IdJsonPatchMessage<String>>>() {
        };
    }

    default TypeReference<ChannelMessage<User, LongMessage>> getLongReferenceType() {
        return new TypeReference<ChannelMessage<User, LongMessage>>() {
        };
    }
}