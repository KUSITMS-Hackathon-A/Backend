package com.kusitms.HackathonA.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository  extends JpaRepository<OrderDetailEntity, Long> {
}
