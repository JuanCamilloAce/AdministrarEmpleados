package co.com.empresa.administradorempleados.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("swaggerConfigProperties")
@Data
@NoArgsConstructor
public class SwaggerConfigProperties {

	/**
	 * apiVersion
	 */
	@Value("${api.version}")
	private String apiVersion;

	/**
	 * enabled
	 */
	@Value("${swagger.enabled}")
	private String enabled = "false";

	/**
	 * title
	 */
	@Value("${swagger.title}")
	private String title;

	/**
	 * description
	 */
	@Value("${swagger.description}")
	private String description;

	/**
	 * useDefaultResponseMessages
	 */
	@Value("${swagger.useDefaultResponseMessages}")
	private String useDefaultResponseMessages;

	/**
	 * enableUrlTemplating
	 */
	@Value("${swagger.enableUrlTemplating}")
	private String enableUrlTemplating;

	/**
	 * deepLinking
	 */
	@Value("${swagger.deepLinking}")
	private String deepLinking;

	/**
	 * defaultModelsExpandDepth
	 */
	@Value("${swagger.defaultModelsExpandDepth}")
	private String defaultModelsExpandDepth;

	/**
	 * defaultModelExpandDepth
	 */
	@Value("${swagger.defaultModelExpandDepth}")
	private String defaultModelExpandDepth;

	/**
	 * displayOperationId
	 */
	@Value("${swagger.displayOperationId}")
	private String displayOperationId;

	/**
	 * displayRequestDuration
	 */
	@Value("${swagger.displayRequestDuration}")
	private String displayRequestDuration;

	/**
	 * filter
	 */
	@Value("${swagger.filter}")
	private String filter;

	/**
	 * maxDisplayedTags
	 */
	@Value("${swagger.maxDisplayedTags}")
	private String maxDisplayedTags;

	/**
	 * showExtensions
	 */
	@Value("${swagger.showExtensions}")
	private String showExtensions;

}
