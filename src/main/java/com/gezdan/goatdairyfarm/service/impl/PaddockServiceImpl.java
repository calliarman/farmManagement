package com.gezdan.goatdairyfarm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gezdan.goatdairyfarm.exception.ResourceNotFoundException;
import com.gezdan.goatdairyfarm.model.Paddock;
import com.gezdan.goatdairyfarm.repository.PaddockRepository;
import com.gezdan.goatdairyfarm.service.PaddockService;

@Service
public class PaddockServiceImpl implements PaddockService {

    @Autowired
    private PaddockRepository paddockRepository;

    @Override
    public List<Paddock> getAllPaddocks() {
        return paddockRepository.findAll();
    }

    @Override
    public Paddock getPaddockById(Long id) {
        Optional<Paddock> paddock = paddockRepository.findById(id);
        if (!paddock.isPresent()) {
            throw new ResourceNotFoundException("paddock", "id", id);
        }
        return paddock.get();
    }

    @Override
    public Paddock createPaddock(Paddock paddock) {
        return paddockRepository.save(paddock);
    }

    @Override
    public Paddock updatePaddock(Paddock paddock) {
        if (!paddockRepository.findById(paddock.getId()).isPresent()) {
            throw new ResourceNotFoundException("paddock", "id", paddock.getId());
        }
        return paddockRepository.save(paddock);
    }

    @Override
    public void deletePaddock(Long id) {
        Optional<Paddock> paddock = paddockRepository.findById(id);
        if (!paddock.isPresent()) {
            throw new ResourceNotFoundException("paddock", "id", id);
        }
        paddockRepository.delete(paddock.get());
    }
}
