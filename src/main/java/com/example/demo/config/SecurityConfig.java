@OpenAPIDefinition(
 security = @SecurityRequirement(name = "bearerAuth")
)
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
          .components(new Components()
          .addSecuritySchemes("bearerAuth",
          new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")));
    }
}