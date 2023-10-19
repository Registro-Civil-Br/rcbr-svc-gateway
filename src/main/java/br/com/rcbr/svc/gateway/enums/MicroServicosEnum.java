package br.com.rcbr.svc.gateway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MicroServicosEnum {

    SVC_NASCIMENTO(
            "Serviço de cadastro de nascimento de pessoa física",
            "https://github.com/Registro-Civil-Br/rcbr-svc-registro-nascimento",
            "/nascimento",
            "SVC-NASCIMENTO",
            "/api/v1/certidao-nascimento"
    ),
    SVC_CPF(
            "Serviço de criação de CPF",
            "https://github.com/Registro-Civil-Br/rcbr-svc-cpf",
            "/cpf",
            "SVC-CPF",
            "/api/v1/cpf"
    );

    private final String descricaoMicroServico;
    private final String urlMicroServicoGithub;
    private final String endpointMicroServicoNoGateway;
    private final String nomeInstanciaMicroServico;
    private final String endpointMicroServico;

}
