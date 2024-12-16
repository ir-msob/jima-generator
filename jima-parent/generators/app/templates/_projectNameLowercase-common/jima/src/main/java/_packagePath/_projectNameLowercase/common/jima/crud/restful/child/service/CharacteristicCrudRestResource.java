package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.restful.child.service;

import com.example.myproject.common.jima.crud.base.child.CharacteristicCrudService;
import com.example.myproject.commondto.jima.child.characteristic.Characteristic;
import com.example.myproject.commondto.jima.child.characteristic.CharacteristicContainer;
import com.example.myproject.commondto.jima.child.characteristic.CharacteristicCriteria;
import com.example.myproject.commondto.jima.dto.Dto;
import com.example.myproject.commondto.jima.security.User;
import ir.msob.jima.crud.api.restful.service.child.characteristic.BaseCharacteristicCrudRestResource;

public interface CharacteristicCrudRestResource<DTO extends Dto & CharacteristicContainer, S extends CharacteristicCrudService<DTO>>
        extends BaseCharacteristicCrudRestResource<
        <%= idClassName %>
        , User
        , Characteristic
        , CharacteristicCriteria
        , CharacteristicContainer
        , DTO
        , S> {

}