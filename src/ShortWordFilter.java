public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        final int LEN_LIMIT = 5;

        boolean isStringOfValidLength = false;
        String s = (String) x;

        if (s.length() < LEN_LIMIT)
        {
            isStringOfValidLength = true;
        }

        return isStringOfValidLength;
    }
}
