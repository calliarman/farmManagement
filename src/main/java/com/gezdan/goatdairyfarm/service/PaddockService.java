package com.gezdan.goatdairyfarm.service;

import java.util.List;

import com.gezdan.goatdairyfarm.model.Paddock;

public interface PaddockService {

    List<Paddock> getAllPaddocks();

    Paddock getPaddockById(Long id);

    Paddock createPaddock(Paddock paddock);

    Paddock updatePaddock(Paddock paddock);

    void deletePaddock(Long id);
}
