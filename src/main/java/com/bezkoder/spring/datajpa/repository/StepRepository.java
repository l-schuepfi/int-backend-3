package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findAllByTutorial_Id(long tutorialId);
}
