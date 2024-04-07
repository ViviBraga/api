package com.medivale.api.paciente;

import com.medivale.api.endereco.DadosCadastroEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

    @NotNull
    Long id,
    
    String nome,
    String telefone,
    DadosCadastroEndereco endereco
) {

}
