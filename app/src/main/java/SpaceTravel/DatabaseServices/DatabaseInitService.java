package SpaceTravel.DatabaseServices;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void initDb() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(DatabaseConstants.DATABASE_URL, null, null)
                .load();

        flyway.migrate();
    }
}
