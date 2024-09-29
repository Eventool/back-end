package com.serenity.api.serenity.controllers;

import com.serenity.api.serenity.dtos.agendamento.AgendamentoRequest;
import com.serenity.api.serenity.dtos.agendamento.AgendamentoResponse;
import com.serenity.api.serenity.dtos.agendamento.AgendamentoUpdateRequest;
import com.serenity.api.serenity.mappers.AgendamentoMapper;
import com.serenity.api.serenity.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final AgendamentoMapper mapper;

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> buscar() {
        List<AgendamentoResponse> agendamentoResponses = agendamentoService.listar().stream()
                .map(AgendamentoResponse::new)
                .collect(Collectors.toList());

        return ok(agendamentoResponses);
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> cadastrar(@RequestBody AgendamentoRequest agendamentoRequest) {
        return created(null).body(new AgendamentoResponse(agendamentoService.cadastrar(mapper.toAgendamento(agendamentoRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarPorId(@PathVariable Integer id) {
        return ok(new AgendamentoResponse(agendamentoService.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> atualizar(@PathVariable Integer id, @RequestBody AgendamentoUpdateRequest agendamentoUpdateRequest) {
        return ok(new AgendamentoResponse(agendamentoService.atualizar(id, mapper.toAgendamento(agendamentoUpdateRequest, agendamentoService.buscarPorId(id)))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Integer id) {
        agendamentoService.deletar(id);
        return noContent().build();
    }
}