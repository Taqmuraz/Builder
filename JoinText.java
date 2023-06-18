
class JoinText implements Text
{
    Text[] texts;
    Text separator;

    public JoinText(Text separator, Text... texts)
    {
        this.separator = separator;
        this.texts = texts;
    }

    @Override
    public void read(Reader reader)
    {
        for(int i = 0; i < texts.length; i++)
        {
            if(i > 0) separator.read(reader);
            texts[i].read(reader);
        }   
    }
}