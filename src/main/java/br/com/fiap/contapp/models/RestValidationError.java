package br.com.fiap.contapp.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
) {}