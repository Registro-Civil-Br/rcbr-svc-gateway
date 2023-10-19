package br.com.rcbr.svc.gateway.config.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

public class LoggingFilter implements GlobalFilter {

    Log log = LogFactory.getLog(getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Set<URI> uris = exchange.getAttributeOrDefault(
                ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR,
                Collections.emptySet());

        String originalUri = (uris.isEmpty())
                ? "Unknown"
                : uris.iterator().next().toString();

        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI routeUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);

        if (route != null)
            log.info("Incoming request " + originalUri + " is routed to: " + route.getFilters() + ", uri: " + routeUri);

        return chain.filter(exchange);
    }
}
