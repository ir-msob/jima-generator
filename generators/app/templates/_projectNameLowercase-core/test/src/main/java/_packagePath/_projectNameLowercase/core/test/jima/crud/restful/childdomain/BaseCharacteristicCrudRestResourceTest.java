package <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.childdomain.characteristic;

import <%= packagePath %>.<%= projectNameLowercase %>.core.test.jima.crud.base.childdomain.ChildCrudRestResourceTest;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.characteristic.Characteristic;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.core.commons.domain.BaseCriteria;
import ir.msob.jima.core.commons.domain.BaseDomain;
import ir.msob.jima.core.commons.domain.BaseDto;
import ir.msob.jima.core.ral.mongo.commons.query.QueryBuilder;
import ir.msob.jima.core.test.Assertable;
import ir.msob.jima.crud.commons.domain.BaseDomainCrudRepository;
import ir.msob.jima.crud.service.childdomain.BaseChildDomainCrudService;
import ir.msob.jima.crud.service.domain.BaseDomainCrudService;
import ir.msob.jima.crud.test.domain.BaseDomainCrudDataProvider;

public abstract class BaseCharacteristicCrudRestResourceTest<
        D extends BaseDomain<<%= idClassName %>>,
        DTO extends BaseDto<<%= idClassName %>>,
        C extends BaseCriteria<<%= idClassName %>>,
        R extends BaseDomainCrudRepository<<%= idClassName %>, User, D, C, QueryBuilder>,
        S extends BaseDomainCrudService<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R>,
        DP extends BaseDomainCrudDataProvider<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S>,

        CS extends BaseChildDomainCrudService<<%= idClassName %>, User, DTO>,
        CDP extends BaseCharacteristicCrudDataProvider<DTO, CS>>
        extends ChildCrudRestResourceTest<D, DTO, C, R, S, DP, CS, CDP>
        implements ir.msob.jima.crud.api.restful.test.childdomain.characteristic.BaseCharacteristicCrudRestResourceTest<<%= idClassName %>, User, Characteristic, CharacteristicCriteria, D, DTO, C, QueryBuilder, R, S, DP, CS, CDP> {


    @Override
    public Assertable<DTO> getUpdateAssertable() {
        return dto -> {
        };
    }

    @Override
    public Assertable<DTO> getDeleteAssertable() {
        return dto -> {
        };
    }

    @Override
    public Assertable<DTO> getSaveAssertable() {
        return dto -> {
        };
    }

    @Override
    public TypeReference<Collection<<%= idClassName %>>> getIdsReferenceType() {
        return new TypeReference<Collection<<%= idClassName %>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}