package net.mpopov.ci.common;

import org.apache.log4j.Logger;

public abstract class ContextAdapter
{
    private static final Logger logger = Logger
            .getLogger(ContextAdapter.class);

    public void process() throws MSCIException
    {
        Context.initializeInstance();

        try
        {
            runProcess();
        }
        catch (MSCIException exception)
        {
            String message = exception.getMessage();
            logger.error(exception.getMessage());
            throw new MSCIException(message, exception);
        }
        finally
        {
            Context.close();
        }
    }

    @SuppressWarnings("unchecked")
    protected <T> T getBean(String name)
    {
        return (T) Context.getInstance().getBean(name);
    }

    protected abstract void runProcess() throws MSCIException;
}
