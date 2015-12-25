package net.mpopov.ci;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import net.mpopov.ci.common.ContextAdapter;
import net.mpopov.ci.common.MSCIException;
import net.mpopov.ci.configuration.Configuration;
import net.mpopov.ci.loader.FileLoader;
import net.mpopov.ci.cruise.importer.CurrencyImporter;

import org.apache.log4j.Logger;

public class MainImporter
{

    private static final Logger logger = Logger.getLogger(MainImporter.class);

    private static final String CURRENCIES_XML = "currencies.xml";

    private static final String CURRENCIES_URL = "http://www.cbr.ru/scripts/XML_daily.asp";

    private static List<SimpleEntry<String, String>> getFileInfo()
    {

        List<SimpleEntry<String, String>> fileInfo = new ArrayList<SimpleEntry<String, String>>();
        fileInfo.add(new SimpleEntry<String, String>(CURRENCIES_URL,
                CURRENCIES_XML));

        return fileInfo;
    }

    private static List<ContextAdapter> getImporters(String directoryPath)
    {
        List<ContextAdapter> importers = new ArrayList<ContextAdapter>();
        importers.add(new CurrencyImporter(directoryPath, CURRENCIES_XML));

        return importers;
    }

    public static void main(String[] args) throws MSCIException
    {

        logger.info("Import is started.");

        String directoryPath = Configuration.getInstance().getTempDirectory();

        List<SimpleEntry<String, String>> fileInfo = getFileInfo();
        FileLoader loader = new FileLoader(fileInfo, directoryPath);
        loader.load();

        List<ContextAdapter> importers = getImporters(directoryPath);

        for (ContextAdapter importer : importers)
        {
            importer.process();
        }

        logger.info("Import is finished.");

    }

}
