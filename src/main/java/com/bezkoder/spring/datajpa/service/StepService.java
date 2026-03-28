package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.model.StepDTO;

import java.util.Set;

public interface StepService {

    Set<StepDTO> findAll();

    Set<StepDTO> findAllByTutorialId(Long tutorialId);

    StepDTO save(StepDTO stepDTO);

    StepDTO update(Long id, StepDTO updatedStepDTO);

    void deleteById(Long id);

}
