package com.gezdan.goatdairyfarm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gezdan.goatdairyfarm.model.Goat;
import com.gezdan.goatdairyfarm.model.Paddock;

@Repository
public interface GoatRepository extends JpaRepository<Goat, Long> {
    List<Goat> findByPaddock(Paddock paddock);
}
