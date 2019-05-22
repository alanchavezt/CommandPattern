package command;

import java.io.*;
import java.util.*;

public class CommandTestDrive
{
    public static void main(String[] args)
    {
        Queue<Command> commandQueue = new ArrayDeque<>();
        Deque<Command> commandStack = new ArrayDeque<>();
        DatabaseMap databaseMap = new DatabaseMap();
        CommandFactory commandFactory = new CommandFactory(databaseMap);

        // Open the file
        Scanner fileIn = null;
        List<String> fileLines;
    	String fileDataName;
        
        try
    	{
        	Scanner in = new Scanner(System.in);
        	System.out.print("Enter a batch file: ");
        	fileDataName = in.nextLine();

    		System.out.println("Batch File: " + fileDataName);
    		fileIn = new Scanner(new File(fileDataName));
		}
    	catch (FileNotFoundException x)
    	{
			System.out.println("File open failed.");
			x.printStackTrace();
			System.exit(0);
		}
    	
        // Reading File
        String line;
        fileLines = new ArrayList<String>();

    	while(fileIn.hasNextLine())
        {
        	line = fileIn.nextLine();
            fileLines.add(line);
        }
    	
    	fileIn.close();
    	
    	// Print file
    	System.out.println("\n********** Printing Batch File *********");
    	for(String l: fileLines)
		{
			System.out.println(l);
		}
    	
    	// Add commands
    	System.out.println("\n********** Processing Batch File *********");
    	for(String c: fileLines)
		{	
			Command command = commandFactory.getCommand(c);
			  
			if (command != null)
			{
				commandQueue.add(command);
			}
		}
    	
    	for (Command c : commandQueue)
        {
            c.execute();
            commandStack.push(c);
        }

        databaseMap.printMap();
        Command undoCommand;
        
        while(!commandStack.isEmpty())
        {
            undoCommand =  commandStack.pop();
            undoCommand.undo();
        }

        databaseMap.printMap();
    	
    }
}
