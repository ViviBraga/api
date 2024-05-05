package com.medivale.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;
import com.medivale.api.domain.consulta.ValidacaoException;
import com.medivale.api.repository.ConsultaRepository;

@Component
public class ValidadorSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia.");
        }
    }

}
