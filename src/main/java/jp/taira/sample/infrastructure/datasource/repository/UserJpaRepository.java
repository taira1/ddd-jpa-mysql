package jp.taira.sample.infrastructure.datasource.repository;

import jp.taira.sample.infrastructure.datasource.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * UserJpaRepository
 */
@Repository
public interface UserJpaRepository extends BaseJpaRepository<UserEntity>, UserJpaRepositoryCustom {
}
