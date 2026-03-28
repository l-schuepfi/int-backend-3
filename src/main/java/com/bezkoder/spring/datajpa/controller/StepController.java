package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.StepDTO;
import com.bezkoder.spring.datajpa.service.StepService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/steps")
public class StepController {
    
    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping
    public Set<StepDTO> getAllSteps() {
        return stepService.findAll();
    }

    @GetMapping("{tutorialId}")
    public Set<StepDTO> getAllStepsByTutorialId(@PathVariable Long tutorialId) {
        return stepService.findAllByTutorialId(tutorialId);
    }

    @PostMapping
    public StepDTO save(@RequestBody StepDTO stepDTO){
        return stepService.save(stepDTO);
    }

    @PutMapping("{id}")
    public StepDTO update(@PathVariable Long id, @RequestBody StepDTO stepDTO) {
        return stepService.update(id, stepDTO);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        stepService.deleteById(id);
    }

}
