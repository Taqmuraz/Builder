
interface Text
{
    void read(Reader reader);

    default String string()
    {
        StringBuilder sb = new StringBuilder();
        read(sb::append);
        return sb.toString();
    }
}