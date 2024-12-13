package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.BaseChildAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildAbstract extends BaseChildAbstract<<%= idClassName %>> implements Child {

    public ChildAbstract(<%= idClassName %> id, <%= idClassName %> parentId) {
        super(id, parentId);
    }
}