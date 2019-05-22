package command;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory
{
    private DatabaseMap databaseMap;
    private List<Command> batchCommand = new ArrayList<>();
    private boolean buildBatch = false;
    private CommandInfo commandInfo;
    private Command command = null;

    public CommandFactory(DatabaseMap databaseMap)
    {
        this.databaseMap = databaseMap;
    }

    public Command getCommand(String currentLine)
    {
    	command = null;
        commandInfo =  parseLine(currentLine);
        
        if (!buildBatch)
        {
            switch (commandInfo.command)
            {
                case "A":
                	command = new AddCommand(new AddObject(databaseMap, commandInfo));
                    break;
                case "U":
                	command = new UpdateCommand(new UpdateObject(databaseMap, commandInfo));
                    break;
                case "R":
                	command = new RemoveCommand(new RemoveObject(databaseMap, commandInfo));
                    break;
                case "B":
                    buildBatch = true;
                    System.out.println("\nBeginning a Macro");
                    break;
                case "E":
                    System.out.println("There is no Batch to end.");
                    break;
                default:
                    System.out.println("Unrecognized command found. and skipped.");
                    break;
            }
        }
        else
        {
            switch (commandInfo.command)
            {
                case "A":
                    batchCommand.add(new AddCommand(new AddObject(databaseMap, commandInfo)));
                    break;
                case "U":
                    batchCommand.add(new UpdateCommand(new UpdateObject(databaseMap, commandInfo)));
                    break;
                case "R":
                    batchCommand.add(new RemoveCommand(new RemoveObject(databaseMap, commandInfo)));
                    break;
                case "B":
                    buildBatch = true;
                    break;
                case "E":
                	command = (new BatchCommand(new BatchObject(batchCommand)));
                    batchCommand = null;
                    buildBatch = false;
                    System.out.println("Ending Macro");
                    break;
                default:
                    System.out.println("Unrecognized command found. and skipped.");
                    break;
            }
        }
        
        return command;
    }

    public CommandInfo parseLine(String currentLine)
    {
    	CommandInfo commandInfo = new CommandInfo();
        String[] line = currentLine.split(" +");
        String value = "";
        
        if (line.length >= 1 )
        {
            commandInfo.command = line[0];
        }

        if (line.length >= 2)
        {
            commandInfo.databaseId = line[1];
        }

        if (line.length >= 3)
        {
            commandInfo.key = line[2];
        }

        if (line.length >= 4)
        {
            int i = 3;
            value = "";
            
            while (i < line.length)
            {
                value += line[i++];
                
                if (i <= line.length - 1)
                {
                    value += " ";
                }
            }
            commandInfo.value = value;
        }

        return commandInfo;
    }
}
