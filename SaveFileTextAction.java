import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class SaveFileTextAction implements TextAction
{
    Text fileName;
    ErrorHandler errorHandler;

    public SaveFileTextAction(Text fileName, ErrorHandler errorHandler)
    {
        this.fileName = fileName;
        this.errorHandler = errorHandler;
    }

    @Override
    public void call(Text text)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName.string())));
            writer.write(text.string());
            writer.close();
        }
        catch(Throwable error)
        {
            errorHandler.error(error);
        }
    }
}