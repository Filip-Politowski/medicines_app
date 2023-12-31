package pl.medicines.medicines_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import pl.medicines.medicines_app.entity.Medication;
import pl.medicines.medicines_app.entity.MedicationsTaken;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3030";

    public void configureRepositoryRestConfiguration (RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] theUnsupportedActions = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT };
        config.exposeIdsFor(Medication.class);
        config.exposeIdsFor(MedicationsTaken.class);

        disableHttpMethods(Medication.class, config, theUnsupportedActions);
        disableHttpMethods(MedicationsTaken.class, config, theUnsupportedActions);

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);

        }

        private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
