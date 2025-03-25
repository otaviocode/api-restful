package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
