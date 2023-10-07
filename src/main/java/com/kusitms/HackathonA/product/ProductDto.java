package com.kusitms.HackathonA.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ProductDto {
    @NoArgsConstructor
    @Data
    public static class Request{

        private String name;
        private String price;
        private String imageUrl;
        private String category;
        private String description;
        private String enterprise;
        private Long progress;

        public Product toEntity() {
            return Product.builder()
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

        private String name;
        private String price;
        private String imageUrl;
        private String category;
        private String description;
        private String enterprise;

        public Response(Product product) {
            this.name=product.getName();
            this.price=product.getPrice();
            this.imageUrl=product.getImageUrl();
            this.category=product.getCategory();
            this.description=product.getDescription();
            this.enterprise=product.getEnterprise();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PreviewResponse {

        private Long productId;
        private String name;
        private String imageUrl;
        private String price;
        private String description;
        private String enterprise;
        private Long progress;


        public PreviewResponse(Product product) {
            this.productId = product.getProductId();
            this.name = product.getName();
            this.imageUrl = product.getImageUrl();
            this.price = product.getPrice();
            this.description = product.getDescription();
            this.enterprise = product.getEnterprise();
            this.progress = product.getProgress();
        }
    }

    public static List<PreviewResponse> toPreviewList(List<Product> productList) {
        return productList.stream()
                .map(PreviewResponse::new)
                .collect(Collectors.toList());
    }
}
