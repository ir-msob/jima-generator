package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.channel;

import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.BaseChannelTypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.ModelType;

public interface ChannelTypeReference<DTO extends Dto, C extends Criteria> extends BaseChannelTypeReference<<%= idClassName %>, User, DTO, C> {

  @Override
  default TypeReference<ChannelMessage<User, ModelType>> getChannelMessageModelTypeReferenceType() {
    return new TypeReference<>() {
    };
  }

  @Override
  default TypeReference<ChannelMessage<User, IdMessage<<%= idClassName %>>>> getChannelMessageIdReferenceType() {
    return new TypeReference<>() {
    };
  }

  @Override
  default TypeReference<ChannelMessage<User, IdsMessage<<%= idClassName %>>>> getChannelMessageIdsReferenceType() {
    return new TypeReference<>() {
    };
  }

  @Override
  default TypeReference<ChannelMessage<User, IdJsonPatchMessage<<%= idClassName %>>>> getChannelMessageIdJsonPatchReferenceType() {
    return new TypeReference<>() {
    };
  }

  @Override
  default TypeReference<ChannelMessage<User, LongMessage>> getChannelMessageLongReferenceType() {
    return new TypeReference<>() {
    };
  }
}