package command;

import java.util.Map.Entry;

public class ActiveDatabase extends Database
{
    public ActiveDatabase(String id)
    {
        super(id);
    }

    public String getID()
    {
        return id;
    }

    public boolean contains(String key)
    {
        if (database.containsKey(key))
        {
            return true;
        }

        return false;
    }

    public void add(String key, String value)
    {
        if (!database.containsKey(key))
        {
            database.put(key, value);
        } 
        else
        {
            System.out.println("Key already exists.");
        }
    }

    public String get(String key)
    {
        if (!database.containsKey(key))
        {
            return "Key does not exist.";
        }
        else
        {
            return database.get(key);
        }
    }

    public void update(String key, String value)
    {
        if (database.containsKey(key))
        {
            database.put(key, value);
        }
        else
        {
            System.out.println("Key does not exist.");
        }
    }

    public void remove(String key)
    {
        if (!database.containsKey(key))
        {
            System.out.println("Key does not exist.");
        }
        else
        {
            database.remove(key);
        }
    }

    public void display()
    {
        database.forEach((k,v)-> System.out.println("Key: " + k + " Value: " + v));
    }

    public String toString()
    {
        StringBuilder returnString = new StringBuilder();
        
        for (Entry<String, String> entry : database.entrySet())
        {
        	returnString.append("\n" + entry.getKey() + " | " + entry.getValue());
        }

        return returnString.toString();
    }
}
