package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.BaseChildDtoAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildDtoAbstract extends BaseChildDtoAbstract<<%= idClassName %>> implements ChildDto {

}