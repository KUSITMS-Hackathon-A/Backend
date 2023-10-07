package com.kusitms.HackathonA.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column
    private String name;
    @Column
    private String price;
    @Column
    private String imageUrl;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private String enterprise;
    @Column
    private Long progress;

}
