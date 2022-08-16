package jp.taira.sample.application.service;

import jp.taira.sample.application.dto.UserCreateRequestDto;
import jp.taira.sample.presentation.response.UserListResponse;

/**
 * ユーザーアプリケーションサービス
 */
public interface UserService {

    void create(UserCreateRequestDto dto);

    UserListResponse list(UserCreateRequestDto dto);
}
