package command;

public class AddObject
{
	DatabaseMap dbMap;
    String dbName;
    String key;
    String value;
    
    public AddObject(DatabaseMap dbMap, CommandInfo command)
    {
        this.dbMap = dbMap;
        this.dbName = command.databaseId;
        this.key = command.key;
        this.value = command.value;
    }

    public void add()
    {
        if (dbMap.map.containsKey(dbName))
        {
        	dbMap.map.get(dbName).add(key, value);
        }
        else
        {
        	dbMap.map.put(dbName, new ActiveDatabase(dbName));
        	dbMap.map.get(dbName).add(key, value);
        }
    }

    public void remove()
    {
        if (dbMap.map.containsKey(dbName))
        {
        	dbMap.map.get(dbName).remove(key);
        	System.out.println("\nUndid AddCommand" + dbMap.map.get(dbName));
//            System.out.println("\nUndid AddCommand\n" + key + " | " + value);
        }
    }
}
