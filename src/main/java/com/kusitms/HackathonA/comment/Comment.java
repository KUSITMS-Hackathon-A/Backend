package com.kusitms.HackathonA.comment;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterpriseId;
}
