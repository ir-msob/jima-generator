package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.kafka.domain.service.write;

import ir.msob.jima.crud.api.kafka.service.domain.write.BaseDeleteManyCrudKafkaListener;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.CrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.CrudRepository;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;

public interface DeleteManyCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends CrudRepository<D, C>,
        S extends CrudService<D, DTO, C, R>
        > extends BaseDeleteManyCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

}