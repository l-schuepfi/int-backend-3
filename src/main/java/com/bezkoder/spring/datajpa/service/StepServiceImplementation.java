package com.bezkoder.spring.datajpa.service;

import com.bezkoder.spring.datajpa.model.Step;
import com.bezkoder.spring.datajpa.model.StepDTO;
import com.bezkoder.spring.datajpa.repository.StepRepository;
import com.bezkoder.spring.datajpa.repository.TutorialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StepServiceImplementation implements StepService {

    private final StepRepository stepRepository;

    private final TutorialRepository tutorialRepository;

    public StepServiceImplementation(StepRepository stepRepository, TutorialRepository tutorialRepository) {
        this.stepRepository = stepRepository;
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Set<StepDTO> findAll() {
        return stepRepository.findAll().stream().map(StepDTO::new).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<StepDTO> findAllByTutorialId(Long tutorialId) {
        return stepRepository.findAllByTutorial_Id(tutorialId).stream().map(StepDTO::new).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public StepDTO save(StepDTO stepDTO) {
        return convertStepToDto(
                stepRepository.save(convertDtoToStep(stepDTO)));
    }

    @Override
    public StepDTO update(Long id, StepDTO updatedStepDTO) {
        Step originalStep = stepRepository.getById(id);

        originalStep.setTitle(updatedStepDTO.getTitle());
        originalStep.setText(updatedStepDTO.getText());
        originalStep.setNumber(updatedStepDTO.getNumber());
        if (updatedStepDTO.getTutorialId() != null) {
            if (tutorialRepository.findById(updatedStepDTO.getTutorialId()).isPresent()) {
                originalStep.setTutorial(tutorialRepository.getById(updatedStepDTO.getTutorialId()));
            } else {
                throw new EntityNotFoundException();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return convertStepToDto(stepRepository.save(originalStep));
    }

    @Override
    public void deleteById(Long id) {
        stepRepository.deleteById(id);
    }

    private Step convertDtoToStep(StepDTO stepDTO) {
        Step step = new Step();

        step.setText(stepDTO.getText());
        step.setTitle(stepDTO.getTitle());
        step.setNumber(stepDTO.getNumber());

        if (stepDTO.getTutorialId() != null) {
            if (tutorialRepository.findById(stepDTO.getTutorialId()).isPresent()) {
                step.setTutorial(tutorialRepository.getById(stepDTO.getTutorialId()));
            }
        }

        return step;
    }

    private StepDTO convertStepToDto(Step step){
        return new StepDTO(step);
    }

}