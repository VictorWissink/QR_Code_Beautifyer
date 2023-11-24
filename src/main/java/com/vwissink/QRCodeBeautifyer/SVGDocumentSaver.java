package com.vwissink.QRCodeBeautifyer;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class SVGDocumentSaver {
    public static void saveAsSVG(Document document, String path) throws Exception {
        // Save the SVG document to a file
        File outputFile = new File(path);
        outputFile.getParentFile().mkdirs();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(Files.newOutputStream(outputFile.toPath())));
        System.out.println("SVG saved to: " + outputFile.getAbsolutePath());
    }

    public static void saveAsPNG(Document svgDocument, String path) throws Exception {
        byte[] imageData = createPNGFromSVG(svgDocument);
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            outputStream.write(imageData);
            System.out.println("PNG saved to: " + path);
        }
    }
    public static byte[] createPNGFromSVG(Document svgDocument) throws Exception {
        // Convert Document to a byte array
        ByteArrayOutputStream svgOutputStream = new ByteArrayOutputStream();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(svgDocument), new StreamResult(svgOutputStream));
        byte[] svgData = svgOutputStream.toByteArray();

        // Setup input for Batik
        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(svgData));

        // Setup output for Batik
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        TranscoderOutput output = new TranscoderOutput(pngOutputStream);

        // Perform the conversion
        PNGTranscoder transcoder = new PNGTranscoder();
        transcoder.transcode(input, output);

        return pngOutputStream.toByteArray();
    }
}
