package com.peixoto.todoo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.peixoto.todoo.entities.Todoo;

public interface TodooRepository extends JpaRepository<Todoo, Integer> {

	@Query("SELECT obj FROM Todoo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
	List<Todoo> findAllOpen();
	
	@Query("SELECT obj FROM Todoo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
	List<Todoo> findAllClose();

}
