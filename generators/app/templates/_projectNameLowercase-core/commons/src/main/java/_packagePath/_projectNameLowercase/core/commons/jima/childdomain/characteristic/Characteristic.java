package <%= packagePath %>.<%= projectNameLowercase %>.core.commons.jima.childdomain.characteristic;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Characteristic extends ir.msob.jima.core.commons.childdomain.characteristic.Characteristic<<%= idClassName %>> {
    @Builder
    public Characteristic(<%= idClassName %> id, <%= idClassName %> parentId, String key, Serializable value, String dataType) {
        super(id, parentId, key, value, dataType);
    }
}