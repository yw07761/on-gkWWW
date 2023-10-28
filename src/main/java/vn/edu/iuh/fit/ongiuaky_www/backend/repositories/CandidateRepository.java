package vn.edu.iuh.fit.ongiuaky_www.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Experience;

import java.util.List;

public class CandidateRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CandidateRepository() {
        entityManager = Persistence
                .createEntityManagerFactory("onGiuaKy")
                .createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insertCandidate(Candidate candidate){
        try {
            transaction.begin();
            entityManager.persist(candidate);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<Candidate> findAllCandidate() {
        return entityManager.createQuery("select can from Candidate can", Candidate.class)
                .getResultList();
    }

    public List<Candidate> getCanditeFromRole(int role){
        try {
            transaction.begin();
            String query = "select distinct ca.can_id,  full_name, email, phone\n" +
                    "from experience e JOIN candidate ca ON  e.can_id = ca.can_id\n" +
                    "where role = ?1;";
            List<Candidate> list = entityManager.createNativeQuery(query, Candidate.class)
                    .setParameter(1, role)
                    .getResultList();
            transaction.commit();
            return list;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return null;
    }

    public List<Candidate> getCanditeUseGmail(){
        try {
            transaction.begin();
            String query = "select * from candidate where email LIKE '%@gmail.com%'";
            List<Candidate> list = entityManager.createNativeQuery(query, Candidate.class)
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
