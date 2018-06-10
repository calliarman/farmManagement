package com.gezdan.goatdairyfarm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gezdan.goatdairyfarm.model.Goat;
import com.gezdan.goatdairyfarm.service.GoatService;

@RestController
@RequestMapping("/api")
public class GoatController {

    @Autowired
    private GoatService goatService;

    @RequestMapping(value = "/goats", method = RequestMethod.GET)
    public List<Goat> getAllGoats() {
        return goatService.getAllGoats();
    }

    @RequestMapping(value = "/goat/{id}", method = RequestMethod.GET)
    public Goat getGoatById(@PathVariable(value = "id") Long id) {
        return goatService.getGoatById(id);
    }

    @RequestMapping(value = "/goat", method = RequestMethod.POST)
    public Goat createGoat(@Valid @RequestBody Goat goat) {
        return goatService.createGoat(goat);
    }

    @RequestMapping(value = "/goat", method = RequestMethod.PUT)
    public Goat updateGoat(@Valid @RequestBody Goat goat) {
        return goatService.updateGoat(goat);
    }

    @DeleteMapping("/goat/{id}")
    public ResponseEntity<?> deleteGoat(@PathVariable(value = "id") Long id) {
        goatService.deleteGoat(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "paddock/{id}/goats", method = RequestMethod.GET)
    public List<Goat> getGoatsOfPaddock(@PathVariable(value = "id") Long id) {
        return goatService.getGoatsOfPaddock(id);
    }
}
