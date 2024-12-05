package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related;

import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.related.characteristic.Characteristic;
import ir.msob.jima.core.commons.related.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.crud.service.related.characteristic.BaseCharacteristicCrudService;
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
