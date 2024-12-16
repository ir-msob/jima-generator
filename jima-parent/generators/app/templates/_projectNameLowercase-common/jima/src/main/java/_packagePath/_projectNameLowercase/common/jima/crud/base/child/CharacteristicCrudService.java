package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child;

import com.example.myproject.commondto.jima.child.characteristic.Characteristic;
import com.example.myproject.commondto.jima.child.characteristic.CharacteristicContainer;
import com.example.myproject.commondto.jima.child.characteristic.CharacteristicCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.service.child.characteristic.BaseCharacteristicCrudService;
import org.springframework.validation.annotation.Validated;

@Validated
public abstract class CharacteristicCrudService<DTO extends Dto & CharacteristicContainer>
        implements BaseCharacteristicCrudService<
        <%= idClassName %>
        , User
        , Characteristic
        , CharacteristicCriteria
        , CharacteristicContainer
        , DTO
        > {

}