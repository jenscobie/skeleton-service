import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AcceptanceTestConfiguration {

    String environment = System.getProperty("environment");
    Config config = ConfigFactory.load(environment);

    public String baseUri = config.getString("baseUri");

    public Integer port = config.getInt("port");
}
