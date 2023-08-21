/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SpaceTravel;

import SpaceTravel.DatabaseServices.DatabaseInitService;
import SpaceTravel.clients.ClientCrudService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

@Slf4j
public class App {

    public static void main(String[] args) {
        new DatabaseInitService().initDb();

        BasicConfigurator.configure();

//        String name = "George Bush";
//        String newName = "Donald Trump";
//
//        ClientCrudService client = new ClientCrudService();
//
//        System.out.println("ID of the new client: " + client.newClient(name)); //new id
//        System.out.println("List of all clients: " + client.allClients()); //list of clients
//        long id = client.getByName(name).getId();
//        System.out.println("ID of client by name: " + id); //id
//
//        client.update(id, newName);
//
//        System.out.println("ID and Name of updated client: " + client.getByName(newName).getId() + " " + client.getById(id).getName());
//        System.out.println("List of all clients: " + client.allClients()); //list of clients
//
//        client.delete(id);
//
//        System.out.println("List of all clients: " + client.allClients()); //list of clients

    }
}
