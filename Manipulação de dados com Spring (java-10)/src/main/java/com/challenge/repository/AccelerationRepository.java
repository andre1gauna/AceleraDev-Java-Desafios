package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    public List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

}