package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.childdomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.BaseChildDomainAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildDomainAbstract extends BaseChildDomainAbstract<<%= idClassName %>> implements ChildDomain {

    public ChildDomainAbstract(<%= idClassName %> id, <%= idClassName %> parentId) {
        super(id, parentId);
    }
}