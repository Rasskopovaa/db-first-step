package Dao;

public class SqlQueries {
    static final String INSERT_INTO_DOGS_VALUES = "INSERT INTO DOGS VALUES(default , ?, ?)";
    static final String SELECT_DOG_BY_ID = "SELECT * FROM DOGS WHERE ID = ?";
    static final String SELECT_DOG_BY_NAME = "SELECT * FROM DOGS WHERE NAME = ?";
    static final String UPDATE_DOGS_BY_ID = "UPDATE DOGS SET NAME=?, AGE=? WHERE ID=?";
    static final String DELETE_FROM_DOGS_BY_ID = "DELETE FROM DOGS WHERE ID=?";

    private SqlQueries() {
    }
}
