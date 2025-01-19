package <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.restful.childdomain.service;

import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.crud.base.childdomain.ChildDomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.commons.jima.security.UserService;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.commons.jima.security.User;
import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.jima.crud.api.restful.service.childdomain.characteristic.BaseCharacteristicCrudRestResource;

public abstract class CharacteristicCrudRestResource<DTO extends Dto, S extends ChildDomainCrudService<DTO>>
        implements BaseCharacteristicCrudRestResource<
        <%= idClassName %>
        , User
        , Characteristic
        , CharacteristicCriteria
        , DTO
        , S> {
        private final S childService;
        private final UserService userService;

        public CharacteristicCrudRestResource(S childService, UserService userService) {
                this.childService = childService;
                this.userService = userService;
        }

        @Override
        public S getChildService() {
                return childService;
        }

        @Override
        public BaseUserService getUserService() {
                return userService;
        }
}