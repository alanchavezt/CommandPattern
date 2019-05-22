package command;

public class AddCommand implements Command
{
    AddObject addObject;

    AddCommand(AddObject addObject)
    {
        this.addObject = addObject;
    }

    public void execute()
    {
        addObject.add();
    }

    public void undo()
    {
        addObject.remove();
    }
}
