package util;

import codec.Format;

public class FileUtil {
    public static String getOutputFilePath(String inputFilePath, Format outputFormat) {
        // Naive implementation.
        return inputFilePath.replaceAll("/input/", "/output/") + "_" + outputFormat;
    }

    public static String getGoldenFilePath(String inputFilePath, Format outputFormat) {
        // Naive implementation.
        return inputFilePath.replaceAll("/input/", "/golden/") + "_" + outputFormat;
    }
}
