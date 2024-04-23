import codec.CodecFactory;
import codec.Deserializer;
import codec.Format;
import codec.Serializer;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Converter {
    private static final Logger LOGGER = Logger.getLogger(Converter.class.getName());


    /**
     * TODO: we could receive a param {@code Type from} and {@code Type to}, so this converter could deserialize and
     * serialize from anything to anything.
     * TODO: infer {@code from}?
     */
    public static void convert(String filePath, Format from, Format to) throws IOException {
        String outputFilePath = filePath + "_" + to;
        LOGGER.log(Level.INFO, "Converting file {0} from format {1} to format {2}. Output file: {3}", new Object[]{filePath, from, to, outputFilePath});

        Deserializer deserializer = CodecFactory.newDeserializer(from);
        Serializer serializer = CodecFactory.newSerializer(to);

        final BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFilePath));

        // TODO: tidy up the exception hanlding and the try with resource.
        try(BufferedReader inputReader = new BufferedReader(new FileReader(filePath))) {
            String originalLine = inputReader.readLine();

            while (originalLine != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
                System.out.println("originalLine: " + originalLine);

                String vanillaLine = deserializer.deserialize(originalLine);
                System.out.println("vanillaLine: " + originalLine);

                String convertedLine = serializer.serialize(vanillaLine);
                System.out.println("convertedLine: " + convertedLine);

                outputWriter.write(convertedLine);
                outputWriter.write(System.lineSeparator());

                originalLine = inputReader.readLine();
            }
//            String everything = sb.toString();
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.WARNING, "File not found {}: {}", new Object[]{filePath, e});
        } finally {
            outputWriter.close();
        }
    }
}
