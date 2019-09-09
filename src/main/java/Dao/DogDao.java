package Dao;

import Pojo.Dog;

public interface DogDao {

    boolean addDog(Dog dog);

    Dog getDogById(int id);

    boolean updateDog(Dog dog);

    boolean deleteDogById(int id);
}
