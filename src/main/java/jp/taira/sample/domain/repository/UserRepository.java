package jp.taira.sample.domain.repository;

import jp.taira.sample.domain.object.UserObject;

import java.util.List;

/**
 * リポジトリインターフェース
 */
public interface UserRepository {

    List<UserObject> getAll();
}
