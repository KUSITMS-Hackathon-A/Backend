package com.kusitms.HackathonA.enterprise;

import com.kusitms.HackathonA.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
public class EnterpriseDto {
    @NoArgsConstructor
    @Data
    public static class Request{
        private String name;

        private String description;

        private String shortsUrl;

        private String articleUrl;

        public Enterprise toEntity() {
            return Enterprise.builder()
                    .name(name)
                    .description(description)
                    .shortsUrl(shortsUrl)
                    .articleUrl(articleUrl)
                    .build();
        }

        public Request(Enterprise enterprise) {
            this.name=enterprise.getName();
            this.description=enterprise.getDescription();
            this.shortsUrl=enterprise.getShortsUrl();
            this.articleUrl=enterprise.getArticleUrl();
        }
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response{


        private String name;

        private String description;

        private String shortsUrl;

        private String articleUrl;


        public Response(Enterprise enterprise) {
            this.name=enterprise.getName();
            this.description=enterprise.getDescription();
            this.shortsUrl=enterprise.getShortsUrl();
            this.articleUrl=enterprise.getArticleUrl();
        }
    }
}
