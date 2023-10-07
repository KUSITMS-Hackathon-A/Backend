package com.kusitms.HackathonA.enterprise;

import com.kusitms.HackathonA.base.BaseResponse;
import com.kusitms.HackathonA.product.Product;
import com.kusitms.HackathonA.product.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enterprise")
@RequiredArgsConstructor
@Api(tags = {"Enterprise API Test"})
public class EnterpriseController {
    private final EnterpriseService enterpriseService;
    private final ModelMapper modelMapper;
    @GetMapping("/list")
    @ApiOperation(value = "기업 소개")
    @ResponseBody
    public ResponseEntity<?> List(){
        Enterprise enterprises = enterpriseService.findByAll();

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("기업 조회 성공")
                .data(enterprises)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("")
    @ApiOperation(value="기업 이름별 상품 조회")
    @ResponseBody
    public ResponseEntity<?> readProductListByEnterprise(@RequestParam String enterpriseName){

        List<ProductDto.Response> resultDto = enterpriseService.readProductListByEnterprise(enterpriseName);

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("기업별 상품 조회 성공")
                .data(resultDto)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
