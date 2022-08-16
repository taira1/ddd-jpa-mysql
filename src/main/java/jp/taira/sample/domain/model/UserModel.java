package jp.taira.sample.domain.model;

import jp.taira.sample.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * モデル
 */
@Component
@RequiredArgsConstructor
public class UserModel {

    private final UserRepository userRepository;

    public void create() {
    }

    public void list() {
        userRepository.getAll();
    }

}
