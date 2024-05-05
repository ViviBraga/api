package com.medivale.api.domain.consulta.validacoes;

import com.medivale.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
