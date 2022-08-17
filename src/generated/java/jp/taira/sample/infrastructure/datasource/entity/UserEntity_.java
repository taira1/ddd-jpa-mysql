package jp.taira.sample.infrastructure.datasource.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ extends jp.taira.sample.infrastructure.datasource.entity.BaseEntity_ {

	public static volatile SingularAttribute<UserEntity, Integer> deleteFlag;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, String> mail;
	public static volatile SingularAttribute<UserEntity, Boolean> registrationFlag;
	public static volatile SingularAttribute<UserEntity, String> nickname;
	public static volatile SingularAttribute<UserEntity, Integer> userType;
	public static volatile SingularAttribute<UserEntity, Long> userId;

	public static final String DELETE_FLAG = "deleteFlag";
	public static final String PASSWORD = "password";
	public static final String MAIL = "mail";
	public static final String REGISTRATION_FLAG = "registrationFlag";
	public static final String NICKNAME = "nickname";
	public static final String USER_TYPE = "userType";
	public static final String USER_ID = "userId";

}

