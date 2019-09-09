package ConnectionManager;

import java.sql.Connection;

/**
 * Интерфейс подключения к БД
 */
public interface ConnectionManager {
    Connection getConnection();
}
