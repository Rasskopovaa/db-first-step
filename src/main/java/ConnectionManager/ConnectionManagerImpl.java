package ConnectionManager;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager {
    // Логгер
    private static Logger logger = Logger.getLogger(ConnectionManagerImpl.class);
    private static ConnectionManager connectionManager;
    //Переменная, хранящая значения переменных из файла conf.properties
    Properties property = new Properties();

    private ConnectionManagerImpl() {

    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    /**
     * Метод проходит по файлу пропертис и находит необходимые значения для коннекта
     *
     * @return
     */
    @Override
    public Connection getConnection() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("conf.properties");
            property.load(stream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        String driver = property.getProperty("driver");
        String password = property.getProperty("password");
        String user = property.getProperty("username");
        String url = property.getProperty("url");
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}
