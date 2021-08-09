package peachy.app.start.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Peachy App Start", version = "v1"))
public class SwaggerConfig {
	
	@Bean
	public GroupedOpenApi NonSecurityGroupOpenApi(@Value("${spring.profiles.active}") String active) {
		return GroupedOpenApi
				.builder()
				.group("Non Security Open Api")
				.addOpenApiCustomiser(buildNonSecurityOpenApi(active))
				.build();
	}
	
	private OpenApiCustomiser buildNonSecurityOpenApi(String active) {
		Server server = new Server();
		String url = "";
		if ("local".equals(active)) {
			url = "http://localhost:8080/";
		} else if ("dev".equals(active)) {
			url = "https://start.app.peachy-dev.com/";
		} else if ("prd".equals(active)) {
			url = "https://start.app.peachy-dev.com/";						
		}
		server.setUrl(url);
		List<Server> serverList = new ArrayList<Server>();
		server.setDescription("피치 App Start Swagger 서버 (" + active + ")");		
		serverList.add(server);
		
		return OpenApi -> OpenApi
				.servers(serverList);
	}
	
}