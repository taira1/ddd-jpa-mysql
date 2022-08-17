package jp.taira.sample.infrastructure.datasource.specification;

import jp.taira.sample.domain.enums.DeleteFlag;
import jp.taira.sample.infrastructure.datasource.entity.UserEntity;
import jp.taira.sample.infrastructure.datasource.entity.UserEntity_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UserSpecification extends BaseSpecification<UserEntity> {

    public static Specification<UserEntity> maxLoginId() {
        return new Specification<UserEntity>() {

            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Subquery<Long> subquery = query.subquery(Long.class);
                Root<UserEntity> subRoot = subquery.from(UserEntity.class);
                subquery.select(cb.max(subRoot.get(UserEntity_.USER_ID)));
                return cb.equal(root.get(UserEntity_.USER_ID), subquery);
            }
        };
    }
}
