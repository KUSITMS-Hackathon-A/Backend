package com.kusitms.HackathonA.enterprise;

import com.kusitms.HackathonA.product.Product;
import com.kusitms.HackathonA.product.ProductDto;
import com.kusitms.HackathonA.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public Enterprise findByAll(){return enterpriseRepository.findByName("RE:BUD");}

    public List<ProductDto.Response> readProductListByEnterprise(String enterpriseName){
        Enterprise enterprise = enterpriseRepository.findByName(enterpriseName);
        List<Product> productList = productRepository.findByEnterpriseId(enterprise);

        List<ProductDto.Response> productListDto = productList.stream()
                .map(data-> modelMapper.map(data, ProductDto.Response.class))
                .collect(Collectors.toList());

        return productListDto;
    }
}
