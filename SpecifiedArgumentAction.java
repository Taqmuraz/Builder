
class SpecifiedArgumentAction implements ArgumentAction
{
    String argument;
    TextAction action;

    public SpecifiedArgumentAction(String argument, TextAction action)
    {
        this.argument = argument;
        this.action = action;
    }

    @Override
    public void call(String argument)
    {
        int index = argument.indexOf('=', 0);
        if(index > 0 && argument.startsWith(this.argument))
        {
            action.call(new ArgumentText(new StringText(argument.substring(index + 1))));
        }
    }
}