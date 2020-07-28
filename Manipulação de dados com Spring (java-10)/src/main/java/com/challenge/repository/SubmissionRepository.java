
package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(value = "select * from submission s inner join acceleration a  on s.challenge_id=a.challenge_id " +
            "where s.challenge_id=?1 and a.id=?2", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

    @Query(value = "select coalesce(max(score),0) from submission where challenge_id=?1", nativeQuery = true)
    BigDecimal findHighestScoreByChallengeId(Long challengeId);
}