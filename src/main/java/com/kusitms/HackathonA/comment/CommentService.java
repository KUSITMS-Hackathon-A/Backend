package com.kusitms.HackathonA.comment;

import com.kusitms.HackathonA.enterprise.Enterprise;
import com.kusitms.HackathonA.enterprise.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final EnterpriseRepository enterpriseRepository;

    List<Comment> findByEnterprise(){

        return commentRepository.findAll();
    }
}
