package <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicCriteria extends ir.msob.jima.core.commons.childdomain.characteristic.CharacteristicCriteria<<%= idClassName %>, Characteristic> {

}