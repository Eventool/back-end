package com.serenity.api.serenity.enums;

public enum TipoRegistro {
    ENTRADA(0, "Entrada"),
    SAIDA(1, "Saída");

    private final int id;
    private final String valor;

    TipoRegistro(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }
}
