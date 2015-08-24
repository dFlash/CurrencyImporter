package net.mpopov.ci.common;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Context
{
    private static final Logger logger = Logger.getLogger(Context.class);

    private static final String DB_APPLICATION_CONTEXT_XML = "dbContext.xml";

    private static ConfigurableApplicationContext instance;

    public static ConfigurableApplicationContext getInstance()
    {
        initializeInstance();

        return instance;
    }

    public static void initializeInstance()
    {
        if (instance == null)
        {
            logger.info(String.format("Loading context %s",
                    DB_APPLICATION_CONTEXT_XML));
            instance = new FileSystemXmlApplicationContext(
                    DB_APPLICATION_CONTEXT_XML);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(String name)
    {
        return (T) instance.getBean(name);
    }

    public static void close()
    {
        if (instance != null)
        {
            instance.close();
            instance = null;
            logger.info(String.format("Context %s was closed.",
                    DB_APPLICATION_CONTEXT_XML));
        }
    }
}
