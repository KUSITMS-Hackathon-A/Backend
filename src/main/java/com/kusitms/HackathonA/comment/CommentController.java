package com.kusitms.HackathonA.comment;

import com.kusitms.HackathonA.base.BaseResponse;
import com.kusitms.HackathonA.enterprise.Enterprise;
import com.kusitms.HackathonA.enterprise.EnterpriseDto;
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
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Api(tags = {"Comment API Test"})
public class CommentController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    @ApiOperation(value = "댓글 조회")
    @ResponseBody
    public ResponseEntity<?> List(){

        List<Comment> comments = commentService.findByEnterprise();
        List<CommentDto> resultDto = comments.stream()
                .map(data-> modelMapper.map(data, CommentDto.class))
                .collect(Collectors.toList());

        BaseResponse baseResponse = BaseResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .success(true)
                .message("댓글 조회 성공")
                .data(resultDto)
                .build();

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
