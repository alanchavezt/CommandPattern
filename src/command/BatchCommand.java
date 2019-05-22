package command;

public class BatchCommand implements Command
{
    BatchObject batchObject;

    BatchCommand(BatchObject batchObject)
    {
    	this.batchObject = batchObject;
    }

    public void execute()
    {
        batchObject.execute();
    }

    public void undo()
    {
        batchObject.undo();
    }
}
