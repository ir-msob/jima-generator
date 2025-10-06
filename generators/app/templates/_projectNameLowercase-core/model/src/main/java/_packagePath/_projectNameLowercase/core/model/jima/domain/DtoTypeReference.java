package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.domain.BaseDtoTypeReference;

import java.lang.reflect.Type;
import java.util.Collection;

public interface DtoTypeReference<DTO extends Dto, C extends Criteria> extends BaseDtoTypeReference<<%= idClassName %>, DTO, C> {
    @Override
    default TypeReference<Collection<<%= idClassName %>>> getIdsReferenceType() {
        return new TypeReference<Collection<<%= idClassName %>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}