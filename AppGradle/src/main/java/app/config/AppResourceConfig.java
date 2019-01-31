package app.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import app.rest.UserController;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/app")
public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		register(UserController.class);

		configureSwagger();
	}

	private void configureSwagger() {
		register(ApiListingResource.class);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setSchemes(new String[] { "http", "https" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/app");
		beanConfig.setResourcePackage("app.rest");
		beanConfig.setPrettyPrint(false);
		beanConfig.setScan();
	}

}


