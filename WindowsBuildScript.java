import java.io.File;
import java.util.Arrays;

class WindowsBuildScript implements Text
{
    Text script;

    public WindowsBuildScript()
    {
        script = new MultilineText(
            compile(),
            createBinary()
        );
    }

    Text compile()
    {
        return new MultilineText(
            new CommandText("rd /s /q", Program.outputPath),
            new CommandText("mkdir", Program.outputPath),
            new StringText("dir /s /b *.java > build/sourcelist.txt"),
            new CommandText(
                new StringText("javac -target"),
                Program.target,
                new StringText("-source "),
                Program.target,
                new StringText("-classpath"),
                new ConcatText(Program.classPath, new StringText("/*")),
                new StringText("-d"),
                Program.outputPath,
                new StringText("@build/sourcelist.txt")),
            new StringText("del build/sourcelist.txt"));
    }

    Text createBinary()
    {
        String[] libs = new File(Program.classPath.string()).list();
        Text classpath;
        if(libs != null)
        {
            Text names = new JoinText(
                new CharText(' '),
                Arrays.stream(libs)
                    .map(StringText::new)
                    .map(t -> new PathText(new StringText(".."), Program.classPath, t))
                    .toArray(Text[]::new));
            classpath = new JoinText(new CharText(' '), new StringText("& echo Class-Path:"), names);
        }
        else classpath = new EmptyText();

        return new MultilineText(
            new CommandText("cd", Program.outputPath),
            new MultilineText(
                new CommandText(
                    "(echo Main-Class:",
                    Program.mainClass,
                    classpath,
                    new StringText("& echo. ) > manifest.txt")),
                new CommandText(
                    "jar -cvfm",
                    new ConcatText(Program.outputBinary, new StringText(".jar")),
                    new StringText("manifest.txt"),
                    Program.inputBinary)
            ),
            new CommandText("cd", new StringText(".."))
        );
    }

    @Override
    public void read(Reader reader)
    {
        script.read(reader);
    }
}