package jp.taira.sample.infrastructure.repository;

import jp.taira.sample.domain.model.UserModel;
import jp.taira.sample.domain.object.UserObject;
import jp.taira.sample.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ユーザーリポジトリ実装クラス
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<UserObject> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
