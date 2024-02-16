package base;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static RequestSpecification requestSpec;
    public static final String API_KEY = System.getenv("THE_CAT_API_KEY");

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Config.BASE_URL)
                .addHeader("x-api-key", Config.API_KEY) // Usa a chave de API do ambiente
                .setContentType("application/json")
                .build();
    }
}


