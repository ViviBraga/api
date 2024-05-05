package com.medivale.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;
import com.medivale.api.domain.consulta.ValidacaoException;

@Component
public class ValidacaoHorarioFuncionamentoDaClinica implements ValidadorAgendamentoDeConsulta{

        public void validar(DadosAgendamentoConsulta dados) {
            var dataConsulta = dados.data();
            var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
            var antesDaAberturaClinica = dataConsulta.getHour() < 7;
            var depoisAberturaClinica = dataConsulta.getHour() > 18;

            if(domingo || antesDaAberturaClinica || depoisAberturaClinica) {
                throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica.");
            }

        }
}
