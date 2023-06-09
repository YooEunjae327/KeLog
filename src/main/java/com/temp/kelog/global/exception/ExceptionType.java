package com.temp.kelog.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "잘못된 입력값입니다."),
    INVALID_TYPE(HttpStatus.BAD_REQUEST, "입력값의 타입이 맞지 않습니다."),
    INVALID_JSON_FORMAT(HttpStatus.BAD_REQUEST, "입력값이 JSON 형식이 아닙니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "잘못된 파라미터가 입력되었습니다."),
    INVALID_HEADER(HttpStatus.BAD_REQUEST, "필수 헤더가 입력되지 않았습니다."),
    INVALID_METHOD(HttpStatus.BAD_REQUEST, "지원하지 않는 HTTP 메서드입니다."),
    INPUT_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "최대 입력 크기를 초과했습니다."),

    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "인증에 실패했습니다."),
    NOT_AUTHENTICATED(HttpStatus.UNAUTHORIZED, "로그인 상태가 아닙니다."),
    CERTIFICATION_FAILED(HttpStatus.UNAUTHORIZED, "이메일 인증에 실패했습니다."),
    NOT_CERTIFICATED(HttpStatus.UNAUTHORIZED, "인증되지 않은 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다."),

    NO_PERMISSION(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    SUSPENDED_USER(HttpStatus.FORBIDDEN, "정지된 사용자입니다."),

    NO_DATA(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다."),
    NO_PLANET(HttpStatus.NOT_FOUND, "참여한 행성이 없습니다."),
    NO_MATE(HttpStatus.NOT_FOUND, "메이트가 없습니다."),

    DUPLICATED(HttpStatus.CONFLICT, "중복된 데이터가 존재합니다."),
    EMAIL_DUPLICATED(HttpStatus.CONFLICT, "중복된 이메일이 존재합니다."),
    NAME_DUPLICATED(HttpStatus.CONFLICT, "중복된 닉네임이 존재합니다."),
    IDENTIFIER_DUPLICATED(HttpStatus.CONFLICT, "중복된 식별자가 존재합니다."),
    PLANET_CREATE_FAILED(HttpStatus.CONFLICT, "행성 생성에 실패했습니다."),
    PLANET_UPDATE_FAILED(HttpStatus.CONFLICT, "행성 수정에 실패했습니다."),
    PLANET_JOIN_FAILED(HttpStatus.CONFLICT, "행성 참여에 실패했습니다."),
    INVALID_IMAGE_TYPE(HttpStatus.CONFLICT, "지원하지 않는 이미지 타입입니다."),
    SOCIAL_ACCOUNT(HttpStatus.CONFLICT, "소셜 계정은 비밀번호를 변경할 수 없습니다."),

    UNKNOWN_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String message;
}
