package software.ulpgc.io;

import software.ulpgc.model.Driver;
import java.util.List;

public interface DriverReader {
    List<Driver> load();
}
