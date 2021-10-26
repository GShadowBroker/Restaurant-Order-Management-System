package app.netlify.gledyson.restaurant.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private Environment env;

    private final Logger log = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // /restaurant is the HTTP URL for the endpoint to which a
        // WebSocket (or SockJS) client will need to connect to for the WebSocket handshake.
        String allowedOrigin = env.getProperty("ALLOWED_ORIGIN_URL");
        log.info("ALLOWED ORIGIN: {}", allowedOrigin);

        registry
                .addEndpoint("/restaurant")
                .setAllowedOrigins(allowedOrigin)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // STOMP messages whose destination header begins with "/app"
        // are routed to @MessageMapping methods in @Controller classes.
        registry.setApplicationDestinationPrefixes("/app");

        // Use the built-in, message broker for subscriptions and broadcasting;
        // Route messages whose destination header begins with "/topic" or "/queue" to the broker
        registry.enableSimpleBroker("/topic", "/queue");
    }
}
