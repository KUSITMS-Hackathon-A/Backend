package com.kusitms.HackathonA.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="order_detail")
 public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    private Long orderId;

    private Long productId;

    @Column
    private Long quantity;

    @Column(columnDefinition = "varchar(255) default '1'")
    private String result; // 1:배송전, 2:배송후
}
