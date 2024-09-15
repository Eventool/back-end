package com.serenity.api.serenity.repositories;

import com.serenity.api.serenity.enums.TipoRegistro;
import com.serenity.api.serenity.models.Agendamento;
import com.serenity.api.serenity.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    Boolean existsByTipoRegistro(TipoRegistro tipoRegistro);
    List<Registro> findAllByAgendamento(Agendamento agendamento);
}
