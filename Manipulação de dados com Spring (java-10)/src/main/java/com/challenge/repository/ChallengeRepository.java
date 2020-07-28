package com.challenge.repository;


import com.challenge.entity.Challenge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    List<Challenge> findByAccelerationsIdAndAccelerationsCandidatesIdUserId(Long accelerationId, Long userId);
}
