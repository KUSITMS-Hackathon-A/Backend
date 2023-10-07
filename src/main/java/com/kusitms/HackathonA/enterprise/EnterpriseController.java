package com.kusitms.HackathonA.enterprise;

import com.kusitms.HackathonA.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        List<Enterprise> enterprises = enterpriseService.findByAll();
        List<EnterpriseDto.Response> resultDto = enterprises.stream()
                .map(data-> modelMapper.map(data, EnterpriseDto.Response.class))
                .collect(Collectors.toList());

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("기업 조회 성공")
                .data(resultDto)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
