package jp.taira.sample.infrastructure.datasource.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BaseSpecification
 */
@SuppressWarnings("hiding")
abstract class BaseSpecification<T> {

    public static <T> Specification<T> isEmpty(final String key) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key)) {
                    return null;
                }
                return cb.isNull(root.get(key));
            }
        };
    }

    public static <T> Specification<T> equals(final String key, final Object value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || (value instanceof String ? StringUtils.isBlank(String.valueOf(value)) : false)) {
                    return null;
                }
                return cb.equal(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> notEquals(final String key, final Object value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || (value instanceof String ? StringUtils.isBlank(String.valueOf(value)) : false)) {
                    return null;
                }
                return cb.notEqual(root.get(key), value);
            }
        };
    }

    protected static <T> Specification<T> like(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.like(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> contains(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return like(key, "%" + value.replace("%", "\\%").replace("_", "\\_") + "%");
    }

    public static <T> Specification<T> startsWith(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return like(key, value.replace("%", "\\%").replace("_", "\\_") + "%");
    }

    public static <T> Specification<T> endsWith(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return like(key, "%" + value.replace("%", "\\%").replace("_", "\\_"));
    }

    protected static <T> Specification<T> notLike(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.notLike(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> notContains(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return notLike(key, "%" + value.replace("%", "\\%").replace("_", "\\_") + "%");
    }

    public static <T> Specification<T> notStartsWith(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return notLike(key, value.replace("%", "\\%").replace("_", "\\_") + "%");
    }

    public static <T> Specification<T> notEndsWith(final String key, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return notLike(key, "%" + value.replace("%", "\\%").replace("_", "\\_"));
    }

    public static <T> Specification<T> groupBy(final List<String> keyList) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.groupBy(keyList.stream().map(x -> root.get(x)).collect(Collectors.toList()));
                return query.getRestriction();
            }
        };
    }

    public static <T> Specification<T> lessThan(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.lessThan(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> lessThanOrEqualTo(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.lessThanOrEqualTo(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> lessThanOrEqualToForDateTime(final String key, final LocalDateTime value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(String.valueOf(value))) {
                    return null;
                }
                return cb.lessThanOrEqualTo(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> greaterThan(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.greaterThan(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> greaterThanOrEqualTo(final String key, final String value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
                    return null;
                }
                return cb.greaterThanOrEqualTo(root.get(key), value);
            }
        };
    }

    public static <T> Specification<T> greaterThanOrEqualToForDateTime(final String key, final LocalDateTime value) {
        return new Specification<T>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (StringUtils.isBlank(key) || StringUtils.isBlank(String.valueOf(value))) {
                    return null;
                }
                return cb.greaterThanOrEqualTo(root.get(key), value);
            }
        };
    }
}
