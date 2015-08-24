package net.mpopov.ci.common;

public abstract class BaseImporter extends ContextAdapter
{
    protected void runProcess() throws MSCIException
    {
        importData();
    }

    protected abstract void importData() throws MSCIException;
}
