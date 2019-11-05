package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examen.entity.Authority;
import com.example.examen.entity.TipoPlato;

@Repository
public interface TipoPlatoRepository extends JpaRepository<TipoPlato, Integer> {

}
