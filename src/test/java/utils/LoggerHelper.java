package utils;

import java.io.File;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {

	static {
        try {
            File file = new File("./src/test/java/resources/log4j2.xml");
            if (file.exists()) {
                Configurator.initialize(null, file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static Logger getLogger(Class<?> cls) {
		return LoggerFactory.getLogger(cls);

	}
}
