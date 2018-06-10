package com.gezdan.goatdairyfarm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gezdan.goatdairyfarm.exception.ResourceNotFoundException;
import com.gezdan.goatdairyfarm.model.Goat;
import com.gezdan.goatdairyfarm.model.Paddock;
import com.gezdan.goatdairyfarm.repository.GoatRepository;
import com.gezdan.goatdairyfarm.repository.PaddockRepository;
import com.gezdan.goatdairyfarm.service.GoatService;

@Service
public class GoatServiceImpl implements GoatService {

    @Autowired
    private GoatRepository goatRepository;

    @Autowired
    private PaddockRepository paddockRepository;

    @Override
    public List<Goat> getAllGoats() {
        return goatRepository.findAll();
    }

    @Override
    public Goat getGoatById(Long id) {
        Optional<Goat> goat = goatRepository.findById(id);
        if (!goat.isPresent()) {
            throw new ResourceNotFoundException("goat", "id", id);
        }
        return goat.get();
    }

    @Override
    public Goat createGoat(Goat goat) {
        return goatRepository.save(goat);
    }

    @Override
    public Goat updateGoat(Goat goat) {
        if (!goatRepository.findById(goat.getId()).isPresent()) {
            throw new ResourceNotFoundException("goat", "id", goat.getId());
        }
        return goatRepository.save(goat);
    }

    @Override
    public void deleteGoat(Long id) {
        Optional<Goat> goat = goatRepository.findById(id);
        if (!goat.isPresent()) {
            throw new ResourceNotFoundException("goat", "id", id);
        }
        goatRepository.delete(goat.get());
    }

    @Override
    public List<Goat> getGoatsOfPaddock(Long paddockId) {
        Optional<Paddock> paddock = paddockRepository.findById(paddockId);
        if (!paddock.isPresent()) {
            throw new ResourceNotFoundException("paddock", "id", paddockId);
        }
        return goatRepository.findByPaddock(paddock.get());
    }
}
