import codec.CodecFactory;
import codec.Deserializer;
import codec.Format;
import codec.Serializer;
import util.FileUtil;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Converter {
    private static final Logger LOGGER = Logger.getLogger(Converter.class.getName());


    /**
     * Converts the content of {@code filePath} from format {@code fromFormat} to {@code toFormat}.
     *
     * TODO: perhaps infer {@code fromFormat} from {@code filePath}.
     */
    public static void convert(String filePath, Format fromFormat, Format toFormat) throws IOException {
        String outputFilePath = FileUtil.getOutputFilePath(filePath, toFormat);
        LOGGER.log(
                Level.INFO,
                "Converting file {0} from format {1} to format {2}. Output file: {3}",
                new Object[]{filePath, fromFormat, toFormat, outputFilePath});

        Deserializer deserializer = CodecFactory.newDeserializer(fromFormat);
        Serializer serializer = CodecFactory.newSerializer(toFormat);

        final BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFilePath));

        // TODO: tidy up the exception handing and the try with resource.
        try(BufferedReader inputReader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line.
            String originalLine = inputReader.readLine();
            String convertedLine = serializer.serialize(deserializer.deserialize(originalLine));
            String nextOriginalLine;
            String nextConvertedLine;

            while (originalLine != null) {
                // Read and convert.
                nextOriginalLine = inputReader.readLine();
                nextConvertedLine = serializer.serialize(deserializer.deserialize(nextOriginalLine));
                convertedLine = serializer.reconcileMultilineArtifacts(convertedLine, nextConvertedLine);

                // Emit.
                outputWriter.write(convertedLine);
                outputWriter.write(System.lineSeparator());

                // Advance.
                originalLine = nextOriginalLine;
                convertedLine = nextConvertedLine;
            }
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, "File not found {}: {}", new Object[]{filePath, e});
        } finally {
            outputWriter.close();
        }
    }
}
