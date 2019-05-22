package command;

public class RemoveCommand implements Command
{
    RemoveObject removeObject;

    RemoveCommand(RemoveObject removeObject)
    {
        this.removeObject = removeObject;
    }

    public void execute()
    {
        removeObject.remove();
    }

    public void undo()
    {
        removeObject.add();
    }
}
