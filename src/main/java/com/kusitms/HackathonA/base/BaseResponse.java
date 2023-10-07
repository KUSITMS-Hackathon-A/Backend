package com.kusitms.HackathonA.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {//BaseResponse 객체를 사용할때 성공, 실패 경우
    private final int code;
    private HttpStatus httpStatus;
    @JsonProperty("isSuccess")
    private final Boolean success;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 요청에 성공한 경우
     */
    public static <T> BaseResponse<T> onSuccess(T data){
        return new BaseResponse<>(200, HttpStatus.OK, true, "요청에 성공하였습니다.", data);
    }


    /**
     * 요청에 실패한 경우
     */
    public static <T> BaseResponse<T> onFailure(int code, String message, T data) {
        return new BaseResponse<>(code, HttpStatus.BAD_REQUEST, false, message, data);
    }
}

