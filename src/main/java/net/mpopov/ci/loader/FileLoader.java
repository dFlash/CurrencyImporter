package net.mpopov.ci.loader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.mpopov.ci.common.MSCIException;
import net.mpopov.ci.configuration.Configuration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileLoader {

	private static final Logger logger = Logger.getLogger(FileLoader.class);

	private List<SimpleEntry<String, String>> fileInfo;

	private String directoryPath;

	public FileLoader(List<SimpleEntry<String, String>> fileInfo,
			String directoryPath) {
		this.fileInfo = fileInfo;
		this.directoryPath = directoryPath;
	}

	public void load() throws MSCIException {

		if (createTempDirecotry(directoryPath)) {
			logger.info(String.format("The directory %s is created.",
					directoryPath));

			for (SimpleEntry<String, String> fileInfoEntry : fileInfo) {

				String urlStringValue = fileInfoEntry.getKey();
				String fileNameValue = fileInfoEntry.getValue();

				try {
					URL url = new URL(urlStringValue);

					File currentFile = new File(directoryPath, fileNameValue);

					FileUtils.copyURLToFile(url, currentFile);

					logger.info(String.format(
							"The file (url = %s, path = %s) is downloaded.",
							urlStringValue, currentFile.getAbsolutePath()));

					TimeUnit.SECONDS.sleep(Configuration.getInstance()
							.getDelay());
				} catch (MalformedURLException exception) {
					String message = String
							.format("The malformed URL %s has occurred",
									urlStringValue);
					logger.error(message);
					throw new MSCIException(message, exception);
				} catch (IOException exception) {
					String message = String.format(
							"The file %s could not be downloaded.",
							fileNameValue);
					logger.error(message);
					throw new MSCIException(message, exception);
				} catch (InterruptedException exception) {
					String message = "The loading is interrupted.";
					logger.error(message);
					throw new MSCIException(message, exception);
				}

			}

		} else {
			String message = String.format(
					"The output directory %s could not be created.",
					directoryPath);
			logger.error(message);
			throw new MSCIException(message);
		}
	}

	private static boolean createTempDirecotry(String filePath) {
		File currentFileDirectory = new File(filePath);
		if (currentFileDirectory.exists() && currentFileDirectory.isDirectory()) {
			return true;
		}
		return currentFileDirectory.mkdir();
	}

}
