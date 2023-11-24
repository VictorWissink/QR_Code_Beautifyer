package com.vwissink.QRCodeBeautifyer;

import com.google.zxing.common.BitMatrix;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SVGDocumentCreator {
    public static Document createSVGDocument(int width, int height) throws ParserConfigurationException {
        // Create and return a new SVG document
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

    public static void addGradientBackground(Document document, String startColor, String stopColor) {
        // Add gradient background to the SVG document
        Element svgRoot = document.getDocumentElement();
        Element defs = document.createElement("defs");
        Element linearGradient = SVGUtils.createLinearGradientElement(document, startColor, stopColor);
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

    public static void drawQRCode(BitMatrix bitMatrix, Document document, String color) {
        // Draw QR code on the SVG document
        Element svgRoot = document.getDocumentElement();
        for (int x = 0; x < bitMatrix.getWidth(); x++) {
            for (int y = 0; y < bitMatrix.getHeight(); y++) {
                if (bitMatrix.get(x, y)) {
                    Element rect = document.createElement("rect");
                    rect.setAttribute("x", String.valueOf(x));
                    rect.setAttribute("y", String.valueOf(y));
                    rect.setAttribute("width", "1");
                    rect.setAttribute("height", "1");
                    rect.setAttribute("fill", color);
                    svgRoot.appendChild(rect);
                }
            }
        }
    }

    public static void addTextLabels(Document document, int width, int height, String topLabel, String bottomLabel, String color) {
        // Add text labels to the SVG document
        Element svgRoot = document.getDocumentElement();
        int maxWidth = width - 50;

        int fontSizeTop = calculateFontSize(topLabel, maxWidth);
        int fontSizeBottom = calculateFontSize(bottomLabel, maxWidth);

        // Top label
        Element textTop = document.createElement("text");
        textTop.setAttribute("x", "50%");
        textTop.setAttribute("y", "55"); // Positioning the top label
        textTop.setAttribute("text-anchor", "middle");
        textTop.setAttribute("font-size", Integer.toString(fontSizeTop));
        textTop.setAttribute("font-family", "Arial, sans-serif");
        textTop.setAttribute("font-weight", "bold");
        textTop.setAttribute("fill", color);
        textTop.setTextContent(topLabel.toUpperCase());
        svgRoot.appendChild(textTop);

        // Bottom label
        Element textBottom = document.createElement("text");
        textBottom.setAttribute("x", "50%");
        textBottom.setAttribute("y", String.valueOf(height - 30)); // Positioning the bottom label
        textBottom.setAttribute("text-anchor", "middle");
        textBottom.setAttribute("font-size", Integer.toString(fontSizeBottom));
        textBottom.setAttribute("font-family", "Arial, sans-serif");
        textBottom.setAttribute("font-weight", "bold");
        textBottom.setAttribute("fill", color);
        textBottom.setTextContent(bottomLabel);
        svgRoot.appendChild(textBottom);
    }

    private static int calculateFontSize(String text, int maxWidth) {
        int maxFontSize = 40;
        int minFontSize = 20;

        int estimatedWidth = (int) (text.length() * maxFontSize * 0.6); // 0.6 is an approximate width for each character

        while (maxFontSize > minFontSize && estimatedWidth > maxWidth) {
            maxFontSize--;
            estimatedWidth = (int) (text.length() * maxFontSize * 0.6);
        }

        return maxFontSize;
    }
}