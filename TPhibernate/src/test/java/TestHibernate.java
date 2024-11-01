import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import util.HibernateConfig;

public class TestHibernate {
    public static void main(String[] args) {
        // Chargement du contexte Spring avec la configuration Hibernate
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        // Vérification de la configuration de SessionFactory
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        if (sessionFactory != null) {
            System.out.println("SessionFactory is configured correctly.");
        } else {
            System.out.println("SessionFactory not found.");
        }

        // Vérification de la configuration de HibernateTransactionManager
        HibernateTransactionManager txManager =
                context.getBean(HibernateTransactionManager.class);
        if (txManager != null) {
            System.out.println("Transaction Manager is configured correctly.");
        } else {
            System.out.println("Transaction Manager not found.");
        }
    }
}
