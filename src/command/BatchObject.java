package command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BatchObject
{
    List<Command> batchCommand = new ArrayList<>();

    public BatchObject(List<Command> batchCommand)
    {
        this.batchCommand = batchCommand;
    }

    public void execute()
    {
        Iterator<Command> myIterator = batchCommand.listIterator();
        
        while(myIterator.hasNext())
        {
            Command myCommand = myIterator.next();
            myCommand.execute();
        }
    }

    public void undo()
    {
    	System.out.println("\nBegin Undoing Macro");
    	
        ListIterator<Command> myIterator = batchCommand.listIterator(batchCommand.size());
        
        while(myIterator.hasPrevious())
        {
            Command myCommand = myIterator.previous();
            myCommand.undo();
        }
        
        System.out.println("\nEnd Undoing Macro");
    }
}
