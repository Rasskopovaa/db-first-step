package Dao;


import ConnectionManager.ConnectionManager;
import ConnectionManager.ConnectionManagerImpl;
import Dao.mappers.DogMapper;
import Pojo.Dog;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DogDaoImpl implements DogDao {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();
    private static Logger logger = Logger.getLogger(DogDaoImpl.class);

    /**
     * Метод сохранения собаки в БД
     *
     * @param dog - собака для сохранения
     * @return true если успешное сохранение, иначе false
     */
    @Override
    public boolean addDog(Dog dog) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SqlQueries.INSERT_INTO_DOGS_VALUES);
            preparedStatement = DogMapper.getPreparedStatementFromDog(preparedStatement, dog);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Метод получения записи из таблицы Dogs по ID
     *
     * @param id - ID записи в таблице
     * @return объект класса Dog
     */
    @Override
    public Dog getDogById(int id) {
        Dog dog = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.SELECT_DOG_BY_ID);
            preparedStatement = DogMapper.getPreparedStatementFromDogID(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                dog = DogMapper.getDogFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return dog;
    }

    //todo:
    @Override
    public boolean updateDog(Dog dog) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(SqlQueries.UPDATE_DOGS_BY_ID);
            preparedStatement = DogMapper.getPreparedStatementFromDog(preparedStatement, dog);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    //todo:
    @Override
    public boolean deleteDogById(int id) {
        Dog dog = null;
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueries.DELETE_FROM_DOGS_BY_ID);
            preparedStatement = DogMapper.getPreparedStatementFromDogID(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                dog = DogMapper.getDogFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}