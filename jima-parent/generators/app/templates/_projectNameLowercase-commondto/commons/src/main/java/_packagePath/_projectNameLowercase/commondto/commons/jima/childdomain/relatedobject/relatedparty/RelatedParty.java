package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.relatedobject.relatedparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.relatedobject.relatedparty.RelatedPartyAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents a related party with a type, an ID, a role, and a referred type.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedParty extends RelatedPartyAbstract<<%= idClassName %>> {

}