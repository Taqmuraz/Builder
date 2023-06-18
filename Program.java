public class Program
{
    static Text sourcePath = new StringText(".");
    static Text classPath = new StringText("lib/*");
    static Text mainClass = new StringText("Program");
    static Text outputPath = new StringText("build");
    static Text outputBinary = new StringText("build");
    static Text target = new StringText("11");
    static Text buildScript = r -> new WindowsBuildScript().read(r);
    static Text runScript = new RunScript();
    static Text extension = new StringText(".bat");
    static Text inputBinary = new StringText(".");

    public static void main(String[] args)
    {
        ErrorHandler errorPrinter = new ErrorPrinter(System.out);
        try
        {
            ArgumentAction argumentAction = new MultipleArgumentAction(
                new SpecifiedArgumentAction("source", arg -> sourcePath = arg),
                new SpecifiedArgumentAction("classpath", arg -> classPath = arg),
                new SpecifiedArgumentAction("main", arg -> mainClass = arg),
                new SpecifiedArgumentAction("output", arg -> outputPath = arg),
                new SpecifiedArgumentAction("target", arg -> target = arg),
                new SpecifiedArgumentAction("name", arg -> outputBinary = arg),
                new SpecifiedArgumentAction("jar-input", arg -> inputBinary = arg),
                new FlagArgumentAction("windows", () ->
                {
                    buildScript = new WindowsBuildScript();
                    extension = new StringText(".bat");
                }),
                new FlagArgumentAction("linux", () ->
                {
                    buildScript = new LinuxBuildScript();
                })
            );
            for(String arg : args) argumentAction.call(arg);

            new SaveFileTextAction(new ConcatText(new StringText("build"), extension), errorPrinter).call(buildScript);
            new SaveFileTextAction(new ConcatText(new StringText("run"), extension), errorPrinter).call(runScript);
        }
        catch(Throwable error)
        {
            errorPrinter.error(error);
        }
    }
}