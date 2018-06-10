package com.gezdan.goatdairyfarm.service;

import java.util.List;

import com.gezdan.goatdairyfarm.model.Goat;

public interface GoatService {

    List<Goat> getAllGoats();

    Goat getGoatById(Long id);

    Goat createGoat(Goat goat);

    Goat updateGoat(Goat goat);

    void deleteGoat(Long id);

    List<Goat> getGoatsOfPaddock(Long paddockId);
}
