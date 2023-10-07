package com.kusitms.HackathonA.product;

import com.kusitms.HackathonA.enterprise.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    private Long progress;


}
