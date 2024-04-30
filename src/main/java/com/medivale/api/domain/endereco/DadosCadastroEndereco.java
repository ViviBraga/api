package com.medivale.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(

    @NotBlank
    String logradouro,

    String numero,
    
    @NotBlank
    String bairro,

    String complemento,
    
    @NotBlank
    String cidade,
    
    @NotBlank
    String uf, 

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep
    ) {

}
