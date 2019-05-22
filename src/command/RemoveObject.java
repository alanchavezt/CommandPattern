package command;

public class RemoveObject
{
	DatabaseMap dbMap;
    String dbName = "";
    String key = "";
    String value = "";
    
    public RemoveObject(DatabaseMap databaseMap, CommandInfo commandInfo)
    {
        this.dbMap = databaseMap;
        this.dbName = commandInfo.databaseId;
        this.key = commandInfo.key;
    }

    public void add()
    {
        if (dbMap.map.containsKey(dbName))
        {
        	dbMap.map.get(dbName).add(key, value);
        	System.out.println("\nUndid RemoveCommand" + dbMap.map.get(dbName));
//            System.out.println("\nUndid RemoveCommand\n" + key + " | " + value);
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
            //need to assign the "value" of this object for the undo command which is add for this command.
            value = dbMap.map.get(dbName).get(key);
            dbMap.map.get(dbName).remove(key);
        }
    }
}
