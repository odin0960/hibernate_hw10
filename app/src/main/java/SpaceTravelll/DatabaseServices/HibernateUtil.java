package SpaceTravelll.DatabaseServices;

import SpaceTravelll.Clients.Client;
import SpaceTravelll.Planets.Planet;
import SpaceTravelll.Tickets.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}