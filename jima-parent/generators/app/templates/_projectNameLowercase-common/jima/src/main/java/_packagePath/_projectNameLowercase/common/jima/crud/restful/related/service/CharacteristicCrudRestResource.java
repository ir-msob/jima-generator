package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.related.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.related.CharacteristicCrudService;
import ir.msob.jima.core.commons.security.BaseUserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import ir.msob.jima.core.commons.related.characteristic.Characteristic;
import ir.msob.jima.core.commons.related.characteristic.CharacteristicCriteria;
import ir.msob.jima.crud.service.related.characteristic.BaseCharacteristicCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.security.UserService;
import ir.msob.jima.crud.api.restful.service.related.characteristic.BaseCharacteristicCrudRestResource;
import org.springframework.beans.factory.annotation.Autowired;

public interface CharacteristicCrudRestResource<
        DTO extends Dto,
        S extends CharacteristicCrudService<DTO>
        > extends
        BaseCharacteristicCrudRestResource<
            <%= idClassName %>
            , User
            , DTO
            , Characteristic<<%= idClassName %>>
            , CharacteristicCriteria<<%= idClassName %>, Characteristic<<%= idClassName %>>>
            , S> {
}
