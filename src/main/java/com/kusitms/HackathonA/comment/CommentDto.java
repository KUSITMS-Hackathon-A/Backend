package com.kusitms.HackathonA.comment;

import com.kusitms.HackathonA.enterprise.Enterprise;
import com.kusitms.HackathonA.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    String enterpriseName;
    String content;
    public CommentDto(Comment comment) {
        this.enterpriseName=comment.getEnterpriseId().getName();
        this.content=comment.getContent();
    }

}
