package <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.kafka.domain.service.read;

import ir.msob.jima.crud.api.kafka.service.domain.read.BaseGetPageCrudKafkaListener;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.security.User;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.dto.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.commondto.jima.criteria.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.CrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.common.jima.crud.base.CrudRepository;
import ir.msob.jima.core.ral.<%= databaseTypeLowercase %>.commons.query.QueryBuilder;

public interface GetPageCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends CrudRepository<D, C>,
        S extends CrudService<D, DTO, C, R>
        > extends BaseGetPageCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, QueryBuilder, R, S> {

}