package com.serenity.api.serenity.dtos.colaborador;

import com.serenity.api.serenity.enums.FuncaoInteresse;
import lombok.Builder;

import java.util.Set;
@Builder
public record ColaboradorRequest(
        Integer idUsuario,
        Set<FuncaoInteresse> funcoesInteresse,
        String cidadeResidencia,
        String estado,
        String apresentacao,
        String experiencia,
        String linkSocial,
        Boolean sociaisAbertas
) {

}
