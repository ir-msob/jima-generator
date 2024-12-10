package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.child.CharacteristicCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import ir.msob.jima.core.commons.child.characteristic.Characteristic;
import ir.msob.jima.core.commons.child.characteristic.CharacteristicCriteria;
import ir.msob.jima.crud.api.restful.service.child.characteristic.BaseCharacteristicCrudRestResource;

public interface CharacteristicCrudRestResource<DTO extends Dto, S extends CharacteristicCrudService<DTO>>
        extends BaseCharacteristicCrudRestResource<
        <%= idClassName %>
        , User
        , DTO
        , Characteristic<<%= idClassName %>>
        , CharacteristicCriteria<<%= idClassName %>, Characteristic<<%= idClassName %>>>
        , S> {

}