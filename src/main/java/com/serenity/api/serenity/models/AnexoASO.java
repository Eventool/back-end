package com.serenity.api.serenity.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnexoASO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate dataEmitido;
    private String urlAnexo;

    @OneToOne
    private Usuario usuario;

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",
                id,  // ID do Anexo
                dataEmitido,  // Data de emissão
                urlAnexo,  // URL do Anexo
                usuario.getId()  // ID do usuário relacionado
        );
    }

}
