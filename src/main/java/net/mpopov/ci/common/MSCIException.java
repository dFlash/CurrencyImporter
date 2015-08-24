package net.mpopov.ci.common;

public class MSCIException extends Exception
{

    private static final long serialVersionUID = -2582670409012043593L;

    public MSCIException()
    {
    }

    public MSCIException(String message)
    {
        super(message);
    }

    public MSCIException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
