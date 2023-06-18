
class StringText implements Text
{
    String string;

    public StringText(String string)
    {
        this.string = string;
    }

    @Override
    public void read(Reader reader)
    {
        int length = string.length();
        for(int i = 0; i < length; i++) reader.read(string.charAt(i));
    }

    @Override
    public String string()
    {
        return string;
    }
}