package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.channel;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.BaseChannelTypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.IdJsonPatchMessage;
import ir.msob.jima.core.commons.channel.message.IdMessage;
import ir.msob.jima.core.commons.channel.message.IdsMessage;
import ir.msob.jima.core.commons.channel.message.LongMessage;
import ir.msob.jima.core.commons.shared.ModelType;

public interface ChannelTypeReference<DTO extends Dto, C extends Criteria> extends BaseChannelTypeReference<<%= idClassName %>, User, DTO, C> {

    default TypeReference<ChannelMessage<User, ModelType>> getModelTypeReferenceType() {
        return new TypeReference<>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdMessage<String>>> getIdReferenceType() {
        return new TypeReference<>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdsMessage<String>>> getIdsReferenceType() {
        return new TypeReference<>() {
        };
    }

    default TypeReference<ChannelMessage<User, IdJsonPatchMessage<String>>> getIdJsonPatchReferenceType() {
        return new TypeReference<>() {
        };
    }

    default TypeReference<ChannelMessage<User, LongMessage>> getLongReferenceType() {
        return new TypeReference<>() {
        };
    }
}