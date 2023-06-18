
class ConcatText implements Text
{
    Text[] texts;
    
    public ConcatText(Text... texts)
    {
        this.texts = texts;
    }

    @Override
    public void read(Reader reader)
    {
        for(Text t : texts) t.read((reader));
    }
}