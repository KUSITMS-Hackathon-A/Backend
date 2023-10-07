package com.kusitms.HackathonA.orders;

import com.kusitms.HackathonA.product.Product;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="orders_id")
    private OrdersEntity ordersId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product productId;

    @Column
    private Long quantity;

    @Column(columnDefinition = "varchar(255) default '1'")
    private String result; // 1:배송전, 2:배송후


}
