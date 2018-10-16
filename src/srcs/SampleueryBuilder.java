package srcs;

import ORM.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SampleueryBuilder {

    public static void main(String[] args) {


        try {

            Session currentSession = poolManager.getSession();
            SessionFactory session = QueryBiulder.buildSessionFactory();
            CriteriaBuilder builder = currentSession.getCriteriaBuilder();
            CriteriaQuery<Employees> criteriaQuery = builder.createQuery(Employees.class);
            criteriaQuery.from(Employees.class);

            Query<Employees> query = currentSession.createQuery(criteriaQuery);
            List<Employees> list = query.getResultList();

            currentSession.close();
            session.close();

            for (Employees e : list) {

                System.out.println(e.getNic());


            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
