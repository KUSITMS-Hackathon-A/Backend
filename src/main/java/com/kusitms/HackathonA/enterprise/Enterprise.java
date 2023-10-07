package com.kusitms.HackathonA.enterprise;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name="enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "enterprise_id")
    private Long enterpriseId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String shortsUrl;

    @Column
    private String articleUrl;

}
