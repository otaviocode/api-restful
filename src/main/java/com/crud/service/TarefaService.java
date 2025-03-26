package com.crud.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crud.model.Tarefa;
import com.crud.repository.TarefaRepository;

@Service
public class TarefaService {

	private final TarefaRepository tarefaRepository;

	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}

	public Tarefa criarTarefa(Tarefa tarefa) {
		tarefa.setDataCriacao(LocalDateTime.now());
		return tarefaRepository.save(tarefa);
	}

	public List<Tarefa> listarTarefas() {
		return tarefaRepository.findAll();
	}

	public Tarefa buscarTarefaPorId(Long id) {
		return tarefaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
	}

	public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));

		tarefa.setTitulo(tarefaAtualizada.getTitulo());
		tarefa.setDescricao(tarefaAtualizada.getDescricao());
		tarefa.setStatus(tarefaAtualizada.getStatus());

		return tarefaRepository.save(tarefa);
	}

	public void excluirTarefa(Long id) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));

		tarefaRepository.delete(tarefa);
	}
}
