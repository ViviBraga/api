package com.medivale.api.medico;

import com.medivale.api.endereco.DadosCadastroEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

    @NotNull
    Long id,
    
    String nome,
    String telefone,
    DadosCadastroEndereco endereco
) {

}
