package com.medivale.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;
import com.medivale.api.domain.consulta.ValidacaoException;

@Component
public class ValidacaoHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 3 minutos.");
        }

    }
}
