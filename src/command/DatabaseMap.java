package command;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DatabaseMap
{
    public Map<String, ActiveDatabase> map;

    public DatabaseMap()
    {
        map = new HashMap<>();
    }

    public void printMap()
    {
    	System.out.print("\nContents of Databases:");
    	
    	for (Entry<String, ActiveDatabase> entry : map.entrySet())
        {
    		System.out.println("\nDatabase " + entry.getKey() + ": " + entry.getValue());	
        }
    }
}
