package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
        List<Company> findByCandidatesIdUserId(Long userId);

        List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);
}
