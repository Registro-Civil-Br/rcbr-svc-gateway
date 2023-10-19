package br.com.rcbr.svc.gateway.services;

import br.com.rcbr.svc.gateway.enums.MicroServicosEnum;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GatewayService {

    public Function<PredicateSpec, Buildable<Route>> constroiRotaPadraoDeComunicacao(MicroServicosEnum microServico) {
        return rota -> rota
                .path(microServico.getEndpointMicroServicoNoGateway() + "/**")
                .filters(f -> {
                    f.rewritePath(
                            microServico.getEndpointMicroServicoNoGateway(),
                            microServico.getEndpointMicroServico()
                    );
                    return f;
                })
                .uri(geraUrlComBalanceamentoDeCarga(microServico.getNomeInstanciaMicroServico()));
    }

    private String geraUrlComBalanceamentoDeCarga(String nomeInstanciaMicroServico) {
        return "lb://" + nomeInstanciaMicroServico + "/";
    }

}
