package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.kafka.domain.service.write;

import ir.msob.jima.crud.api.kafka.service.domain.write.BaseEditByIdDomainCrudKafkaListener;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.domain.DomainCrudRepository;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;
public interface EditByIdDomainCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseEditByIdDomainCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

}