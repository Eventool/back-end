package com.serenity.api.serenity.repositories;

import com.serenity.api.serenity.models.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormularioRepository extends JpaRepository<Formulario, UUID> {
}
