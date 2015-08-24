package net.mpopov.ci.xml.model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.mpopov.ci.common.MSCIException;

import org.apache.log4j.Logger;

public class ModelUtil
{
    private static final Logger logger = Logger.getLogger(ModelUtil.class);

    public static <K, V> K getRootType(String directoryPath, String fileName,
            Class<V> classToBeBound) throws MSCIException
    {
        K rootType = null;

        File file = new File(directoryPath, fileName);
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(classToBeBound);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            @SuppressWarnings("unchecked")
            JAXBElement<K> unmarshalledObject = (JAXBElement<K>) unmarshaller
                    .unmarshal(file);

            rootType = unmarshalledObject.getValue();
        }
        catch (JAXBException exception)
        {
            String message = String.format(
                    "The xml file %s could not be parsed.",
                    file.getAbsolutePath());
            logger.error(message);
            throw new MSCIException(message, exception);
        }

        return rootType;
    }
}
