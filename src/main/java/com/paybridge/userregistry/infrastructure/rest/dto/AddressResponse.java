package com.paybridge.userregistry.infrastructure.rest.dto;

public record AddressResponse(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado
) {
}
