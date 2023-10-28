package vn.edu.iuh.fit.ongiuaky_www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Experience;

import java.util.List;

public class ExperienceRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ExperienceRepository() {
        entityManager = Persistence
                .createEntityManagerFactory("onGiuaKy")
                .createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insertExperience(Experience experience){
        try {
            transaction.begin();
            entityManager.persist(experience);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<Experience> findAllExperienceFromCanId(long canId) {
        try {
            transaction.begin();
            String query = "select * from experience where can_id = ?1";
            List<Experience> list = entityManager.createNativeQuery(query, Experience.class)
                    .setParameter(1, canId)
                    .getResultList();
            transaction.commit();
            return list;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

}
