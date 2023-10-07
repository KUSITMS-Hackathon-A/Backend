package com.kusitms.HackathonA.user;

import com.kusitms.HackathonA.orders.OrdersEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "usert_id")
    private Long userId;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String zipCode;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private Long useyn;

    @Column
    private Date regDate;

    @OneToMany(mappedBy = "ordersId")
    private List<OrdersEntity> ordersEntityList;



}
