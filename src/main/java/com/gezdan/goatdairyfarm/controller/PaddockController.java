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

import com.gezdan.goatdairyfarm.model.Paddock;
import com.gezdan.goatdairyfarm.service.PaddockService;

@RestController
@RequestMapping("/api")
public class PaddockController {

    @Autowired
    private PaddockService paddockService;

    @RequestMapping(value = "/paddocks", method = RequestMethod.GET)
    public List<Paddock> getAllPaddocks() {
        return paddockService.getAllPaddocks();
    }

    @RequestMapping(value = "/paddock/{id}", method = RequestMethod.GET)
    public Paddock getPaddockById(@PathVariable(value = "id") Long id) {
        return paddockService.getPaddockById(id);
    }

    @RequestMapping(value = "/paddock", method = RequestMethod.POST)
    public Paddock createPaddock(@Valid @RequestBody Paddock paddock) {
        return paddockService.createPaddock(paddock);
    }

    @RequestMapping(value = "/paddock", method = RequestMethod.PUT)
    public Paddock updatePaddock(@Valid @RequestBody Paddock paddock) {
        return paddockService.updatePaddock(paddock);
    }

    @DeleteMapping("/paddock/{id}")
    public ResponseEntity<?> deletePaddock(@PathVariable(value = "id") Long id) {
        paddockService.deletePaddock(id);
        return ResponseEntity.ok().build();
    }
}
