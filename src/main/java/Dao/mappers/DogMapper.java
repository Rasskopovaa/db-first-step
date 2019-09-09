package Dao.mappers;

import Pojo.Dog;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DogMapper {
    private static Logger logger = Logger.getLogger(DogMapper.class);

    private DogMapper() {
    }

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

    public static PreparedStatement getPreparedStatementFromDog(PreparedStatement preparedStatement, Dog dog) {
        try {
            preparedStatement.setString(1, dog.getName());
            preparedStatement.setInt(2, dog.getAge());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromDogID(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return preparedStatement;
    }
}
