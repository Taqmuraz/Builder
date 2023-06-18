
class PathText implements Text
{
    Text text;

    public PathText(Text... elements)
    {
        text = new JoinText(new CharText('/'), elements);
    }

    @Override
    public void read(Reader reader)
    {
        text.read(reader);
    }
}