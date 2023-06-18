
class FlagArgumentAction implements ArgumentAction
{
    String argument;
    Action action;

    public FlagArgumentAction(String argument, Action action)
    {
        this.argument = argument;
        this.action = action;
    }

    @Override
    public void call(String argument)
    {
        if(this.argument.equals(argument)) action.call();
    }
}