package com.kusitms.HackathonA.product;

import com.kusitms.HackathonA.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Api(tags = {"Product API Test"})
public class ProductController {

    private final ProductRepository ProductRepository;

    @PostMapping("")
    @ApiOperation(value = "상품 등록")
    @ResponseBody
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto.Request productDto){

            Product product = productDto.toEntity();
            Long productId = ProductRepository.save(product).getProductId();

            BaseResponse baseResponse = BaseResponse.builder()
                    .code(HttpStatus.CREATED.value())
                    .httpStatus(HttpStatus.CREATED)
                    .success(true)
                    .message("상품 등록 성공")
                    .data(productId)
                    .build();

            return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "상품 조회")
    @ResponseBody
    public ResponseEntity<?> readProduct(@PathVariable Long productId){

        Product product = ProductRepository.findByProductId(productId);
        ProductDto.Response result = new ProductDto.Response(product);

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("상품 조회 성공")
                .data(result)
                .build();


        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("")
    @ApiOperation(value = "카테고리별 상품 조회")
    @ResponseBody
    public ResponseEntity<?> readProductByCategory(@RequestParam(name="category", defaultValue = "all") String category) {

        List<Product> productList;

        if ("all".equals(category)) {
            productList = ProductRepository.findAll();
        } else {
            productList = ProductRepository.findByCategory(category);
        }
        List<ProductDto.PreviewResponse> result = ProductDto.toPreviewList(productList);
        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("카테고리별 상품 조회 성공")
                .data(result)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
