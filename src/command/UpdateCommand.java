package command;

public class UpdateCommand implements Command
{
    UpdateObject updateObject;

    UpdateCommand(UpdateObject updateObject)
    {
        this.updateObject = updateObject;
    }

    public void execute()
    {
        updateObject.update();
    }

    public void undo()
    {
        updateObject.undo();
    }
}
