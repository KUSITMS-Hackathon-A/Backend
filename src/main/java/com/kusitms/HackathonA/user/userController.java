package com.kusitms.HackathonA.user;

import com.kusitms.HackathonA.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Api(tags = {"User API Test"})
public class userController {

    private final UserRepository userRepository;
    private final UserService userService;

    //유저 등록
    @PostMapping("")
    @ApiOperation(value = "유저 등록")
    @ResponseBody
    public ResponseEntity<?> saveProduct(@RequestBody UserDto.Request userDto){

        UserEntity userEntity = userDto.toEntity();
        Long userId = userRepository.save(userEntity).getUserId();

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .success(true)
                .message("유저 등록 성공")
                .data(userId)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/mypage/{userId}")
    @ApiOperation(value = "유저마다 마이페이지 조회")
    @ResponseBody
    public ResponseEntity<?> readMypage (@PathVariable Long userId){

        //유저마다 구매한 상품 리스트
        //유저마다 구매 이력이 있는 기업 리스트

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("유저 마이페이지 조회 성공")
                .data(userId)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
