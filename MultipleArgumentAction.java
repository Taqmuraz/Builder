
class MultipleArgumentAction implements ArgumentAction
{
    ArgumentAction[] actions;
    
    public MultipleArgumentAction(ArgumentAction... actions)
    {
        this.actions = actions;
    }

    @Override
    public void call(String argument)
    {
        for(ArgumentAction a : actions) a.call(argument);
    }   
}