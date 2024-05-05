package com.medivale.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;
import com.medivale.api.domain.consulta.ValidacaoException;
import com.medivale.api.repository.ConsultaRepository;

@Component
public class ValidadorMedicoOutraConsultaMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data()); 

        if(medicoPossuiOutraConsultaMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário.");
        }

    }
}
