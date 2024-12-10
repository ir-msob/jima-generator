package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.child.characteristic.Characteristic;
import ir.msob.jima.core.commons.child.characteristic.CharacteristicCriteria;
import ir.msob.jima.crud.service.child.characteristic.BaseCharacteristicCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class CharacteristicCrudService<DTO extends Dto>
        implements BaseCharacteristicCrudService<
            <%= idClassName %>
            , User
            , DTO
            , Characteristic<<%= idClassName %>>
            , CharacteristicCriteria<<%= idClassName %>, Characteristic<<%= idClassName %>>>> {

}