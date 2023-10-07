package com.kusitms.HackathonA.enterprise;

import com.kusitms.HackathonA.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {

    Enterprise findByName(String enterpriseName);

    List<Product> findByEnterpriseId(Long enterpriseId);
}
