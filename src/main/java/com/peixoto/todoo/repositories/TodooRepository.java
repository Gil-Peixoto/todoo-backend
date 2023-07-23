package com.peixoto.todoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peixoto.todoo.entities.Todoo;

@Repository
public interface TodooRepository extends JpaRepository<Todoo, Integer> {

}
