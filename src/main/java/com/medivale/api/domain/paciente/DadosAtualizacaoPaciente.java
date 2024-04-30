package com.medivale.api.domain.paciente;

import com.medivale.api.domain.endereco.DadosCadastroEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

    @NotNull
    Long id,
    
    String nome,
    String telefone,
    DadosCadastroEndereco endereco
) {

}
