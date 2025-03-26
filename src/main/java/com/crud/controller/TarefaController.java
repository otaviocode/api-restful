package com.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Tarefa;
import com.crud.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	private final TarefaService tarefaService;

	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	@PostMapping
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
		Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
	}

	@GetMapping
	public ResponseEntity<List<Tarefa>> listarTarefas() {
		List<Tarefa> tarefas = tarefaService.listarTarefas();
		return ResponseEntity.ok(tarefas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.buscarTarefaPorId(id);
		return ResponseEntity.ok(tarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
		return ResponseEntity.ok(tarefaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
		tarefaService.excluirTarefa(id);
		return ResponseEntity.noContent().build();
	}
}
