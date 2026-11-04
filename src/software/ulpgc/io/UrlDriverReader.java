package software.ulpgc.io;

import software.ulpgc.model.Driver;
import software.ulpgc.model.Team;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UrlDriverReader implements DriverReader{
    private final URL url;

    public UrlDriverReader(URL url) {
        this.url = url;
    }

    @Override
    public List<Driver> load() {
        try {
            try (InputStream is = url.openStream()) {
                return loadFrom(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Driver> loadFrom(InputStream is) throws IOException {
        return loadFrom(new InputStreamReader(is));
    }

    private List<Driver> loadFrom(Reader reader) throws IOException {
        return loadFrom(reader.readAllLines());
    }

    private List<Driver> loadFrom(List<String> lines) {
        return IntStream.range(1, lines.size()).mapToObj(i -> loadFrom(lines.get(i))).collect(Collectors.toList());
    }

    private Driver loadFrom(String s) {
        return loadFrom(s.split(","));
    }

    private Driver loadFrom(String[] split) {
        return new Driver(split[0], split[1], Integer.parseInt(split[2]), team(split[3]));
    }

    private Team team(String team) {
        return team.isEmpty() ? null : Team.valueOf(team);
    }
}
