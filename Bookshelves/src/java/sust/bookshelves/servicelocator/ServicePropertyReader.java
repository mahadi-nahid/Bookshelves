package sust.bookshelves.servicelocator;

import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.net.URL;
import java.util.Properties;
import java.io.Serializable;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;


/**
 * Read the service to implementation mappings from the services.properties file.
 * @author  Nahid and Afjal  sust
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public class ServicePropertyReader implements Serializable {

    /**
     * De logger.
     */
    private static Logger log = LogService.getLogger(ServicePropertyReader.class);

    /**
     * property file waarin applicatie configuraties staan.
     */
    private static final String SERVICES_PROPERTIES_FILE_PATH = "/service.properties";

    /**
     * property.
     */
    private static Properties properties = null;

    /**
     * Lees de woz online property file in.
     *
     * @return properties, null als de properties niet worden gevonden.
     *
     */
    public static synchronized Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                URL url = ServicePropertyReader.class.getResource(SERVICES_PROPERTIES_FILE_PATH);
                properties.load(url.openStream());
            } catch (Exception ex) {
                // If the properties are not loaded, it's fatal!
                log.fatal("Property file: " + SERVICES_PROPERTIES_FILE_PATH + " could not be read!", ex);
                return null;
            }
        }
        return properties;
    }

    /**
     * Read a property .
     *
     * @param propertyName the property name
     * @return property value of the property, otherwise: <tt>null</tt>
     */
    public static String getProperty(String propertyName) {
        return getProperties().getProperty(propertyName);
    }

    /**
     * Read a property with a fall back value.
     *
     * @param propertyName the property name.
     * @param defaultValue fall back value
     * @return property value if not null, otherwise the fallback value.
     */
    public static String getProperty(String propertyName, String defaultValue) {
        return getProperties().getProperty(propertyName, defaultValue);
    }
}
