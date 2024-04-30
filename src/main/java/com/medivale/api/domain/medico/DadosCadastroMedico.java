package com.medivale.api.domain.medico;

import com.medivale.api.domain.endereco.DadosCadastroEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

    @NotBlank
    String nome, 
    
    @Email
    @NotBlank
    String email,

    @NotBlank
    String telefone, 

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm, 
    
    @NotNull
    Especialidade especialidade, 

    @NotNull
    @Valid
    DadosCadastroEndereco endereco
    ) {

}
