package com.kusitms.HackathonA.product;

import com.kusitms.HackathonA.enterprise.Enterprise;
import com.kusitms.HackathonA.orders.OrderDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name="product")
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

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterpriseId;
    @Column
    private String progressTitle;
    @Column
    private String progressDescription;
    @Column
    private Long progress;

    @OneToMany(mappedBy = "orderDetailId")
    private List<OrderDetailEntity> orderDetailEntityList;

    @Column
    private String imageUrl1;
    @Column
    private String imageUrl2;
    @Column
    private String description1;
    @Column
    private String description2;

}
