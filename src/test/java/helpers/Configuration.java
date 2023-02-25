package helpers;

import com.mysql.cj.util.DnsSrv;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final String SITE_ADDRESS = "test.site.url";
    private static final String DRIVER_LOCATION = "driver.location";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String DB_USER = "dbUser";
    private static final String DB_URL = "dbUrl";
    private static final String DB_PASSWORD = "dbPassword";
    private static Configuration configuration;
    private final Properties properties;
    private final String siteURL;
    private final String driverLocation;
    public final String email;
    public final String password;
    public final String firstName;
    public final String lastname;
    public final String dbUser;
    public final String dbUrl;
    public final String dbPassword;

    public Configuration() {
        try {
            properties = new Properties();
            properties.load(Configuration.class.getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (
                IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
        siteURL = extractProperty(SITE_ADDRESS);
        driverLocation = extractProperty(DRIVER_LOCATION);
        email = extractProperty(EMAIL);
        password = extractProperty(PASSWORD);
        firstName = extractProperty(FIRSTNAME);
        lastname = extractProperty(LASTNAME);
        dbUser = extractProperty(DB_USER);
        dbUrl = extractProperty(DB_URL);
        dbPassword = extractProperty(DB_PASSWORD);
    }

    private String extractProperty(String propertyName) {
        String property = System.getProperty(propertyName);
        if (property == null) {
            property = properties.getProperty(propertyName);
        }
        return property;
    }

    public static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    public String get(String property) {
        return extractProperty(property);
    }

    public String getSiteURL() {
        return siteURL;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbUrl() {return dbUrl;}

    public String getDbPassword() {return dbPassword;}
}
