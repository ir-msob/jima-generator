package <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.BaseDomainAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomainAbstract extends BaseDomainAbstract<<%= idClassName %>> implements Domain{

    public DomainAbstract(<%= idClassName %> id) {
        super(id);
    }
}