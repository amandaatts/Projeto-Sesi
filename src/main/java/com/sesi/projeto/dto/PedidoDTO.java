package com.sesi.projeto.dto;

import java.time.Instant;

import com.sesi.projeto.entities.StatusDoPedido;

public record PedidoDTO(Long id, Instant momento, StatusDoPedido status ) {

}
