public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        final int LEN_LIMIT = 5;
        String s = (String) x;

        return (s.length() < LEN_LIMIT);
    }
}
