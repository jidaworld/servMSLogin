package DataLayer.DBHandler;

import BusinessLayer.Entities.UserEntity;
import DataLayer.IDBHandler.IDBHandler;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DBHandler implements IDBHandler {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");

    public DBHandler() {
    }

    public boolean loginUser(String email, String password) {
        EntityManager em = emf.createEntityManager();
        UserEntity userEntity;
        try {
            TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
            query.setParameter(1, email);
            userEntity = query.getSingleResult();
            if(userEntity != null){
                return BCrypt.checkpw(password, userEntity.getPassword());
            }

        } catch (Exception e) {
            System.out.println("lagg");
        }

        return false;
    }
}
