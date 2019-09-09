import Dao.DogDao;
import Dao.DogDaoImpl;
import Pojo.Dog;
import org.apache.log4j.Logger;


public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
        DogDao dogDao = new DogDaoImpl();
        Dog dog = new Dog(0, "Nastya", 30);
        dogDao.addDog(dog);
        logger.info(dogDao.getDogById(0));
    }
}
