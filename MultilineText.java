
class MultilineText implements Text
{
    Text text;

    public MultilineText(Text... lines)
    {
        text = new JoinText(new CharText('\n'), lines);
    }

    @Override
    public void read(Reader reader)
    {
        text.read(reader);
    }
}