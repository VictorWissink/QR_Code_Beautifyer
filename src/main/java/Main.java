import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        int width = 400;
        int height = 450;
        String startColor = "rgb(253,200,48)";
        String stopColor = "rgb(243,115,53)";
        String url = "www.victorwissink.nl";
        String topLabel = "iOS Col 1 Build";
        String bottomLabel = "Bund-Next-Col-1";

        try {
            BitMatrix bitMatrix = generateQRCode(url, width, height);
            Document document = createSVGDocument(width, height);
            addGradientBackground(document, startColor, stopColor);
            drawQRCode(bitMatrix, document);
            addTextLabels(document, height, topLabel, bottomLabel);
            saveAsSVG(document, "target/QRcode.svg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BitMatrix generateQRCode(String url, int width, int height) throws Exception {
        return new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
    }

    private static Document createSVGDocument(int width, int height) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element svgRoot = document.createElement("svg");
        svgRoot.setAttribute("xmlns", "http://www.w3.org/2000/svg");
        svgRoot.setAttribute("width", Integer.toString(width));
        svgRoot.setAttribute("height", Integer.toString(height));
        document.appendChild(svgRoot);
        return document;
    }

    private static void addGradientBackground(Document document, String startColor, String stopColor) {
        Element svgRoot = (Element) document.getDocumentElement();
        Element defs = document.createElement("defs");
        Element linearGradient = createLinearGradientElement(document, startColor, stopColor);
        defs.appendChild(linearGradient);
        svgRoot.appendChild(defs);

        Element background = document.createElement("rect");
        background.setAttribute("width", "100%");
        background.setAttribute("height", "100%");
        background.setAttribute("rx", "30"); // Rounded corner radius
        background.setAttribute("ry", "30"); // Rounded corner radius
        background.setAttribute("fill", "url(#backgroundGradient)");
        svgRoot.appendChild(background);
    }

    private static Element createLinearGradientElement(Document document, String startColor, String stopColor) {
        Element linearGradient = document.createElement("linearGradient");
        linearGradient.setAttribute("id", "backgroundGradient");
        linearGradient.setAttribute("x1", "0%");
        linearGradient.setAttribute("y1", "0%");
        linearGradient.setAttribute("x2", "100%");
        linearGradient.setAttribute("y2", "100%");
        linearGradient.appendChild(createColorStop(document, "0%", startColor));
        linearGradient.appendChild(createColorStop(document, "100%", stopColor));
        return linearGradient;
    }

    private static Element createColorStop(Document document, String offset, String color) {
        Element stop = document.createElement("stop");
        stop.setAttribute("offset", offset);
        stop.setAttribute("style", "stop-color:" + color + ";stop-opacity:1");
        return stop;
    }

    private static void drawQRCode(BitMatrix bitMatrix, Document document) {
        Element svgRoot = (Element) document.getDocumentElement();
        for (int x = 0; x < bitMatrix.getWidth(); x++) {
            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                if (bitMatrix.get(x, y)) {
                    Element rect = document.createElement("rect");
                    rect.setAttribute("x", String.valueOf(x));
                    rect.setAttribute("y", String.valueOf(y));
                    rect.setAttribute("width", "1");
                    rect.setAttribute("height", "1");
                    rect.setAttribute("fill", "white");
                    svgRoot.appendChild(rect);
                }
            }
        }
    }

    private static void addTextLabels(Document document, int height, String topLabel, String bottomLabel) {
        Element svgRoot = (Element) document.getDocumentElement();

        // Top label
        Element textTop = document.createElement("text");
        textTop.setAttribute("x", "50%");
        textTop.setAttribute("y", "55"); // Positioning the top label
        textTop.setAttribute("text-anchor", "middle");
        textTop.setAttribute("font-size", "40");
        textTop.setAttribute("font-family", "Arial, sans-serif");
        textTop.setAttribute("font-weight", "bold");
        textTop.setAttribute("fill", "white");
        textTop.setTextContent(topLabel);
        svgRoot.appendChild(textTop);

        // Bottom label
        Element textBottom = document.createElement("text");
        textBottom.setAttribute("x", "50%");
        textBottom.setAttribute("y", String.valueOf(height - 30)); // Positioning the bottom label
        textBottom.setAttribute("text-anchor", "middle");
        textBottom.setAttribute("font-size", "40");
        textBottom.setAttribute("font-family", "Arial, sans-serif");
        textBottom.setAttribute("font-weight", "bold");
        textBottom.setAttribute("fill", "white");
        textBottom.setTextContent(bottomLabel);
        svgRoot.appendChild(textBottom);
    }

    private static void saveAsSVG(Document document, String path) throws Exception {
        File outputFile = new File(path);
        outputFile.getParentFile().mkdirs();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(outputFile)));
        System.out.println("SVG saved to: " + outputFile.getAbsolutePath());
    }
}