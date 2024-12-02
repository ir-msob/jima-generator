package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.related.relatedaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.related.relatedaction.RelatedActionAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedAction extends RelatedActionAbstract<<%= idClassName %>> {

}