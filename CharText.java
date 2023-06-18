
class CharText implements Text
{
    char c;
    public CharText(char c)
    {
        this.c = c;
    }
    @Override
    public void read(Reader reader)
    {
        reader.read(c);    
    }
}