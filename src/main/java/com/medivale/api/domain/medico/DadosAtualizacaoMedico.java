package com.medivale.api.domain.medico;

import com.medivale.api.domain.endereco.DadosCadastroEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

    @NotNull
    Long id,
    
    String nome,
    String telefone,
    DadosCadastroEndereco endereco
) {

}
