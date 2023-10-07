package com.kusitms.HackathonA.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Builder
public class ProductDto {
    @NoArgsConstructor
    @Data
    public static class Request{
        private Long productId;

        private String name;

        private String price;

        private String imageUrl;

        private String category;

        private String description;

        private String enterprise;

        private Long progress;

        public Product toEntity() {
            return Product.builder()
                    .productId(productId)
                    .name(name)
                    .price(price)
                    .imageUrl(imageUrl)
                    .category(category)
                    .description(description)
                    .enterprise(enterprise)
                    .progress(progress)
                    .build();
        }

        public Request(Product product) {
            this.productId = getProductId();
            this.name=getName();
            this.price=getPrice();
            this.imageUrl=getImageUrl();
            this.category=getCategory();
            this.description=getDescription();
            this.enterprise=getEnterprise();
            this.progress=getProgress();
        }
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response{

        private Long productId;

        private String name;

        private String price;

        private String imageUrl;

        private String category;

        private String description;

        private String enterprise;

        private Long progress;

        public Response(Product product) {
            this.productId = getProductId();
            this.name=getName();
            this.price=getPrice();
            this.imageUrl=getImageUrl();
            this.category=getCategory();
            this.description=getDescription();
            this.enterprise=getEnterprise();
            this.progress=getProgress();
        }

    }
}
