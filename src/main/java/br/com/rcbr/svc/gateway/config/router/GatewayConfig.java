package br.com.rcbr.svc.gateway.config.router;

import br.com.rcbr.svc.gateway.enums.MicroServicosEnum;
import br.com.rcbr.svc.gateway.services.GatewayService;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder, GatewayService gatewayService) {
        return builder.routes()
                .route(gatewayService.constroiRotaPadraoDeComunicacao(MicroServicosEnum.SVC_NASCIMENTO))
                .route(gatewayService.constroiRotaPadraoDeComunicacao(MicroServicosEnum.SVC_CPF))
                .build();
    }

}
