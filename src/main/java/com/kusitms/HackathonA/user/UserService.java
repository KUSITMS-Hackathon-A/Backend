package com.kusitms.HackathonA.user;

import com.kusitms.HackathonA.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String readMypage (Long userId){

        //유저 이름 찾기
        String userName = userRepository.findByUserId(userId).getName();

        //유저마다 구매한 상품 리스트

        //유저마다 구매 이력이 있는 기업 리스트


        return "hello";
    }

}
