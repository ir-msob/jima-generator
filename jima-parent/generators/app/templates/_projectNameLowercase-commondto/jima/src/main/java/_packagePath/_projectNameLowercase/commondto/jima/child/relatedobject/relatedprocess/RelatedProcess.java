package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedprocess;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.relatedobject.relatedprocess.RelatedProcessAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a related process with a type, an ID, a role, and a referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedProcess extends RelatedProcessAbstract<<%= idClassName %>> {
}