package <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.kafka.domain.service.read;

import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudRepository;
import <%= packagePath %>.<%= projectNameLowercase %>.core.service.jima.crud.base.domain.DomainCrudService;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.channel.ChannelTypeReference;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Criteria;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Domain;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.domain.Dto;
import <%= packagePath %>.<%= projectNameLowercase %>.core.model.jima.security.User;
import ir.msob.jima.crud.api.kafka.service.domain.read.BaseCountDomainCrudKafkaListener;

public interface CountDomainCrudKafkaListener<
        D extends Domain,
        DTO extends Dto,
        C extends Criteria,
        R extends DomainCrudRepository<D, C>,
        S extends DomainCrudService<D, DTO, C, R>
        > extends BaseCountDomainCrudKafkaListener<<%= idClassName %>, User, D, DTO, C, R, S>
        , ChannelTypeReference<DTO, C> {

}