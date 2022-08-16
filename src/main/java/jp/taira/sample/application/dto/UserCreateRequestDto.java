package jp.taira.sample.application.dto;

import lombok.Data;

@Data
public class UserCreateRequestDto {
    private String query;
    private Integer count;
}
