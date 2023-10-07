package com.kusitms.HackathonA.product;

import com.kusitms.HackathonA.enterprise.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
        private String imageUrl1;
        private String imageUrl2;
        private String description1;
        private String description2;

        public Product toEntity() {
            return Product.builder()
                    .name(name)
                    .price(price)
                    .imageUrl(imageUrl)
                    .category(category)
                    .description(description)
                    .name(enterprise)
                    .progress(progress)
                    .imageUrl1(imageUrl1)
                    .imageUrl2(imageUrl2)
                    .description1(description1)
                    .description2(description2)
                    .build();
        }

        public Request(Product product) {
            this.name=product.getName();
            this.price=product.getPrice();
            this.imageUrl=product.getImageUrl();
            this.category=product.getCategory();
            this.description=product.getDescription();
            this.enterprise=product.getEnterpriseId().getName();
            this.imageUrl1=product.getImageUrl1();
            this.imageUrl2=product.getImageUrl2();
            this.description1=product.getDescription1();
            this.description2=product.getDescription2();
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
        private String progressTitle;

        private String progressDescription;
        private Long progress;
        private String imageUrl1;
        private String imageUrl2;
        private String description1;
        private String description2;

        public Response(Product product) {
            this.name=product.getName();
            this.price=product.getPrice();
            this.imageUrl=product.getImageUrl();
            this.category=product.getCategory();
            this.description=product.getDescription();
            this.enterprise=product.getEnterpriseId().getName();
            this.progressTitle=product.getProgressTitle();
            this.progressDescription=product.getProgressDescription();
            this.progress=product.getProgress();
            this.imageUrl1=product.getImageUrl1();
            this.imageUrl2=product.getImageUrl2();
            this.description1=product.getDescription1();
            this.description2=product.getDescription2();
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
            this.enterprise = product.getEnterpriseId().getName();
            this.progress = product.getProgress();
        }
    }

    public static List<PreviewResponse> toPreviewList(List<Product> productList) {
        return productList.stream()
                .map(PreviewResponse::new)
                .collect(Collectors.toList());
    }
}
