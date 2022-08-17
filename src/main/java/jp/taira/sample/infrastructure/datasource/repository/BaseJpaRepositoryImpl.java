package jp.taira.sample.infrastructure.datasource.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * BaseJpaRepositoryImpl
 */
abstract class BaseJpaRepositoryImpl<T> extends SimpleJpaRepository<T, Long> implements BaseJpaRepository<T> {

    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

}
