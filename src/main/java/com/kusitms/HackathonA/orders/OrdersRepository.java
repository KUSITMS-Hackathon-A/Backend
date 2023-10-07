package com.kusitms.HackathonA.orders;

import com.kusitms.HackathonA.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    //특정 회원이 구매한 모든 상품 조회
    List<OrdersEntity> findByUserId(UserEntity userEntity);


}
