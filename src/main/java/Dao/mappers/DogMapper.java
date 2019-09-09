package Dao.mappers;

import Pojo.Dog;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс маппер записей в объекты класса Dog
 */
public class DogMapper {
    private static Logger logger = Logger.getLogger(DogMapper.class);

    private DogMapper() {
    }

    /**
     * Метод формирует объект класса Dog из полученного resultSet
     *
     * @param resultSet  - результат запроса
     * @return объект класса Dog
     */
    public static Dog getDogFromResultSet(ResultSet resultSet) {
        Dog dog = null;
        try {
            if (resultSet.next()) {
                dog = new Dog(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return dog;
    }

    /**
     * Заполняет значения preparedStatement значениями объекта dog
     *
     * @param preparedStatement Незаполненный preparedStatement (с вопросиками)
     * @param dog - объект класса Dog
     * @return заполненный PreparedStatement
     */
    public static PreparedStatement getPreparedStatementFromDog(PreparedStatement preparedStatement, Dog dog) {
        try {
            preparedStatement.setString(1, dog.getName());
            preparedStatement.setInt(2, dog.getAge());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }

    /**
     * Заполняет значения preparedStatement значением id
     *
     * @param preparedStatement Незаполненный preparedStatement (с вопросиком)
     * @param id - id собаки
     * @return заполненный PreparedStatement
     */
    public static PreparedStatement getPreparedStatementFromDogID(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }
}
