import java.io.PrintStream;

class ErrorPrinter implements ErrorHandler
{
    PrintStream stream;

    public ErrorPrinter(PrintStream stream)
    {
        this.stream = stream;
    }

    @Override
    public void error(Throwable error)
    {
        while(error != null)
        {
            error.printStackTrace(stream);
            error = error.getCause();
        }
    }
}