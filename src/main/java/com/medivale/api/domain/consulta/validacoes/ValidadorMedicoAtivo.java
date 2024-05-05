package com.medivale.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;
import com.medivale.api.domain.consulta.ValidacaoException;
import com.medivale.api.repository.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico.");
        }
    }
}
