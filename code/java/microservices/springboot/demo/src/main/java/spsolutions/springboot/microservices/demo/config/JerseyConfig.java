package spsolutions.springboot.microservices.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import spsolutions.springboot.microservices.demo.endpoint.EntityDemoEndpoint;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(EntityDemoEndpoint.class);
    }
}
