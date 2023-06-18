
class RunScript implements Text
{
    @Override
    public void read(Reader reader)
    {
        new CommandText(
            "java -Xms64M -jar",
            new ConcatText(new PathText(Program.outputPath, Program.outputBinary),
            new StringText(".jar"))).read(reader);
    }
    
}