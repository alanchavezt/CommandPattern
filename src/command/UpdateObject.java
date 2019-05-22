package command;

public class UpdateObject
{
    DatabaseMap dbMap;
    String dbName;
    String key;
    String value;
    String previousValue = "";

    public UpdateObject(DatabaseMap dbMap, CommandInfo commandInfo)
    {
        this.dbMap = dbMap;
        this.dbName = commandInfo.databaseId;
        this.key = commandInfo.key;
        this.value = commandInfo.value;
    }

    public void update()
    {
        if (dbMap.map.containsKey(dbName))
        {
            previousValue = dbMap.map.get(dbName).get(key);
            dbMap.map.get(dbName).update(key, value);
        }
    }

    public void undo()
    {
        if (dbMap.map.containsKey(dbName))
        {
        	dbMap.map.get(dbName).update(key, previousValue);
        	
//            System.out.println("\nUndid UpdateCommand\n" + key + " | " + previousValue);
            System.out.println("\nUndid UpdateCommand" + dbMap.map.get(dbName));
        }
    }
}
