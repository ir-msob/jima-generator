package <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.child.contactmedium;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.child.contactmedium.ContactMediumAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMedium extends ContactMediumAbstract<<%= idClassName %>> {
}
