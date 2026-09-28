public class ShortWordFilter implements Filter
{
    String word;

    public ShortWordFilter(String word)
    {
        this.word = word;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

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
