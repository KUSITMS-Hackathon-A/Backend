package com.kusitms.HackathonA.enterprise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findByAll(){return enterpriseRepository.findAll();}

}
