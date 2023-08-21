package SpaceTravel.clients;

import SpaceTravel.DatabaseServices.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientCrudService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCrudService.class);

    public void create(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public long newClient(String name) {

        long id = -1L;
        try {
            if (name == null || name.length() > 200 || name.length() < 3) {
                throw new IllegalArgumentException();
            } else {
                Client client = new Client();
                client.setName(name);
                create(client);
                return client.getId();
            }
        } catch (Exception ex) {
            LOGGER.error("The name length must be greater than 2 character but less than 200 characters", ex);
        }
        return id;
    }

    public Client getById(long id)  {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public Client getByName(String name)  {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client where name = :name", Client.class);
            query.setParameter("name", name);
            return query.getSingleResult();
//            return query.stream().findFirst().orElse(null);
        }
    }

    public List<Client> allClients() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    public void update(long id, String newName)  {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client updatedClient = getById(id);
            if (updatedClient == null) {
                throw new IllegalArgumentException();
            } else {
                Transaction transaction = session.beginTransaction();
                updatedClient.setName(newName);
                session.persist(updatedClient);
                transaction.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("The client with such ID is not exist", ex);
        }
    }

    public void delete(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client client = getById(id);
            if (client == null) {
                throw new IllegalArgumentException();
            } else {
                Transaction transaction = session.beginTransaction();
                session.remove(client);
                transaction.commit();
            }
        } catch (Exception ex) {
            LOGGER.error("The client with such ID is not exist", ex);
        }
    }
}

//    session.createQuery("delete from Client where id = :id")
//        .setParameter("id", id)
//        .executeUpdate();

//        session.createNativeQuery("DELETE FROM user WHERE id = :id")
//        .setParameter("id", user.getId())
//        .executeUpdate();

//    Client client = getById(id);
//            session.createQuery("from Client", Client.class).list();
//        session.persist(updatedClient);


//    Query<Passenger> query = session.createQuery(
//            "from Passenger where passport = :passport",
//            Passenger.class
//    );
//            query.setParameter("passport", passport);
//            return query.stream().findFirst().orElse(null);

//            Query<Long> query = session.createQuery(
//                    "select count(id) from Ticket t WHERE t.to = :to",
//                    Long.class);
//            query.setParameter("to", planet);
//            return query.getSingleResult();

