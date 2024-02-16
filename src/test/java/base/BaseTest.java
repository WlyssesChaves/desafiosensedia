package base;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Config.BASE_URL)
                .addHeader("x-api-key", "live_9ArHy1ayRgyMni0bISvJ8lGgUH5FdleCaBsfMhXlSocqnQKo0HoR6vn76wCuJud0") // Usa a chave de API do ambiente
                .setContentType("application/json")
                .build();
    }
}


