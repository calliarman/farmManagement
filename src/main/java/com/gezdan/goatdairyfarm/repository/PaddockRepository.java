package com.gezdan.goatdairyfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gezdan.goatdairyfarm.model.Paddock;

@Repository
public interface PaddockRepository extends JpaRepository<Paddock, Long> {

}
