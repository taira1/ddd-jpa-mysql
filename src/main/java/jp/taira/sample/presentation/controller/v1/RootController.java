package jp.taira.sample.presentation.controller.v1;

import jp.taira.sample.common.UrlConstants;
import jp.taira.sample.presentation.controller.BaseController;
import jp.taira.sample.presentation.request.LoginRequest;
import jp.taira.sample.presentation.response.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * コントローラークラス
 */
@RestController
@RequestMapping(UrlConstants.ROOT)
@Tag(name = "")
@RequiredArgsConstructor
@Slf4j
public class RootController extends BaseController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "テスト", description = "")
    public void test() {
        log.debug("test");
    }

    @RequestMapping(value = UrlConstants.LOGIN, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "ログイン", description = "")
    public LoginResponse login(@RequestBody LoginRequest param) {

        return null;
    }
}
