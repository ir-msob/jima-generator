package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.BaseDtoAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoAbstract extends BaseDtoAbstract<<%= idClassName %>> implements Dto {

    public DtoAbstract(<%= idClassName %> id) {
        super(id);
    }
}