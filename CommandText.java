
class CommandText implements Text
{
    Text command;

    public CommandText(Text command, Text... args)
    {
        this.command = new ConcatText(command, new CharText(' '), new JoinText(new CharText(' '), args));
    }
    public CommandText(String command, Text... args)
    {
        this(new StringText(command), args);
    }

    @Override
    public void read(Reader reader)
    {
        command.read(reader);
    }
}