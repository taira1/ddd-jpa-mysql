package jp.taira.sample.application.service.impl;

import jp.taira.sample.application.dto.UserCreateRequestDto;
import jp.taira.sample.application.dto.UserResponseDto;
import jp.taira.sample.application.service.UserService;
import jp.taira.sample.domain.model.UserModel;
import jp.taira.sample.presentation.response.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ユーザーアプリケーションサービス
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserModel userModel;

    @Override
    public void create(UserCreateRequestDto dto) {
        userModel.create();
    }

    @Override
    public UserListResponse list(UserCreateRequestDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
