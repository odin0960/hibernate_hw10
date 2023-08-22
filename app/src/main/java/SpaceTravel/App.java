package SpaceTravel;

import SpaceTravel.Clients.ClientCrudService;
import SpaceTravel.DatabaseServices.DatabaseInitService;
import SpaceTravel.Planets.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        new DatabaseInitService().initDb();

        String name = "George Bush";
        String name3 = "X";
        String newName = "Donald Trump";

        ClientCrudService clientService = new ClientCrudService();
        clientService.newClient(name);
        clientService.newClient(name3);
        LOGGER.info("Client_By_Id = " + clientService.getById(10L)); //Client(id=10, name=Oleksandr Karavayev)
        LOGGER.info("Client_By_Name = " + clientService.getByName(name)); //Client(id=13, name=George Bush)
        LOGGER.info("All_Clients = " + clientService.allClients());
        clientService.update(13L, newName);
        LOGGER.info("Client_By_Id = " + clientService.getById(13L)); //Client(id=13, name=Donald Trump)
        LOGGER.info("All_Clients = " + clientService.allClients());
        clientService.delete(13L);
        LOGGER.info("All_Clients = " + clientService.allClients());

        PlanetCrudService planetService = new PlanetCrudService();
        Planet planet = new Planet();
        planet.setName("Pluto");
        planet.setId("PLU09");
        planetService.create(planet);
        LOGGER.info("Planet_By_Id = " + planetService.getById("MAR04")); // Planet(id=MAR04, name=Mars)
        LOGGER.info("Planet_By_Name = " + planetService.getByName("Saturn")); // Planet(id=SAT06, name=Saturn)
        LOGGER.info("All_Planets = " + planetService.allPlanets());
        planetService.update("PLU09", "Pluton");
        LOGGER.info("Planet_By_Id = " + planetService.getById("PLU09")); // Planet(id=PLU09, name=Pluton)
        LOGGER.info("All_Planets = " + planetService.allPlanets());
        planetService.delete("PLU09");
        LOGGER.info("All_Planets = " + planetService.allPlanets());

    }
}
