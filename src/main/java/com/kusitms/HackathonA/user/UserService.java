package com.kusitms.HackathonA.user;

import com.kusitms.HackathonA.base.BaseResponse;
import com.kusitms.HackathonA.orders.OrdersEntity;
import com.kusitms.HackathonA.orders.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrdersRepository ordersRepository;

    public List<OrdersEntity> readMypage (Long userId){

        //유저 이름 찾기
        String userName = userRepository.findByUserId(userId).getName();

        //회원아이디로 주문 조회. 주문으로 주문내역 조회. 주문내역으로 상품 조회. 상품으로 기업 조회.
        List<OrdersEntity> ordersEntityList = userRepository.findByUserId(userId).getOrdersEntityList();

        //유저마다 구매한 상품 리스트

        //유저마다 구매 이력이 있는 기업 리스트


        return ordersEntityList;
    }

}
