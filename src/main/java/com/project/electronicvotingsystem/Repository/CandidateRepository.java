package com.project.electronicvotingsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.electronicvotingsystem.Entity.CandidateEntity;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,Integer> {

}
