package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.auditdomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.auditdomain.AuditDomainAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.relatedobject.relatedparty.RelatedParty;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditDomain extends AuditDomainAbstract<<%= idClassName %>, RelatedParty> {

}