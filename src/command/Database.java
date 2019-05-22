package command;

import java.util.HashMap;
import java.util.Map;

public abstract class Database
{
    Map<String, String> database = new HashMap<>();
    String id;

    public Database(String id)
    {
        this.id = id;
    }

    public String getID()
    {
        return id;
    }

    public abstract void add(String key, String value);

    public abstract String get(String key);

    public abstract void update(String key, String value);

    public abstract void remove(String key);

    public abstract void display();

    public abstract String toString();
}
