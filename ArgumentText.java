
class ArgumentText implements Text
{
    Text text;

    public ArgumentText(Text text)
    {
        this.text = text;
    }

    @Override
    public void read(Reader reader)
    {
        text.read(c ->
        {
            if(c != '\"') reader.read(c);
        });
    }
}