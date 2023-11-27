package com.vwissink.QRCodeBeautifyer;

import com.google.zxing.common.BitMatrix;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Map;

import static java.util.Map.entry;

public class SVGDocumentCreator {

    private static final Map<Character, Double> charWidths = Map.ofEntries(
            entry(' ', 4.4453125),
               entry('!', 4.4453125),
               entry('"', 5.6796875),
               entry('#', 8.8984375),
               entry('$', 8.8984375),
               entry('%', 14.2265625),
               entry('&', 10.671875),
               entry('\'', 3.0546875),
               entry('(', 5.328125),
               entry(')', 5.328125),
               entry('*', 6.2265625),
               entry('+', 9.34375),
               entry(',', 4.4453125),
               entry('-', 5.328125),
               entry('.', 4.4453125),
               entry('/', 4.4453125),
               entry('0', 8.8984375),
               entry('1', 7.7228125),
               entry('2', 8.8984375),
               entry('3', 8.8984375),
               entry('4', 8.8984375),
               entry('5', 8.8984375),
               entry('6', 8.8984375),
               entry('7', 8.8984375),
               entry('8', 8.8984375),
               entry('9', 8.8984375),
               entry(':', 4.4453125),
               entry(';', 4.4453125),
               entry('<', 9.34375),
               entry('=', 9.34375),
               entry('>', 9.34375),
               entry('?', 8.8984375),
               entry('@', 16.2421875),
               entry('A', 10.671875),
               entry('B', 10.671875),
               entry('C', 11.5546875),
               entry('D', 11.5546875),
               entry('E', 10.671875),
               entry('F', 9.7734375),
               entry('G', 12.4453125),
               entry('H', 11.5546875),
               entry('I', 4.4453125),
               entry('J', 8.0),
               entry('K', 10.671875),
               entry('L', 8.8984375),
               entry('M', 13.328125),
               entry('N', 11.5546875),
               entry('O', 12.4453125),
               entry('P', 10.671875),
               entry('Q', 12.4453125),
               entry('R', 11.5546875),
               entry('S', 10.671875),
               entry('T', 9.7734375),
               entry('U', 11.5546875),
               entry('V', 10.671875),
               entry('W', 15.1015625),
               entry('X', 10.671875),
               entry('Y', 10.671875),
               entry('Z', 9.7734375),
               entry('[', 4.4453125),
               entry('\\', 4.4453125),
               entry(']', 4.4453125),
               entry('^', 7.5078125),
               entry('_', 8.8984375),
               entry('`', 5.328125),
               entry('a', 8.8984375),
               entry('b', 8.8984375),
               entry('c', 8.0),
               entry('d', 8.8984375),
               entry('e', 8.8984375),
               entry('f', 4.15921875),
               entry('g', 8.8984375),
               entry('h', 8.8984375),
               entry('i', 3.5546875),
               entry('j', 3.5546875),
               entry('k', 8.0),
               entry('l', 3.5546875),
               entry('m', 13.328125),
               entry('n', 8.8984375),
               entry('o', 8.8984375),
               entry('p', 8.8984375),
               entry('q', 8.8984375),
               entry('r', 5.328125),
               entry('s', 8.0),
               entry('t', 4.4453125),
               entry('u', 8.8984375),
               entry('v', 8.0),
               entry('w', 11.5546875),
               entry('x', 8.0),
               entry('y', 8.0),
               entry('z', 8.0),
               entry('{', 5.34375),
               entry('|', 4.15625),
               entry('}', 5.34375),
               entry('~', 9.34375)
    );

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
        textTop.setTextContent(topLabel);
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

    public static int calculateFontSize(String text, int maxWidth) {
        maxWidth = maxWidth * 15; // adjust maxWidth to account for the font width
        int maxFontSize = 40;
        int minFontSize = 10;

        double estimatedWidth = calculateTextWidth(text, maxFontSize);

        while (maxFontSize > minFontSize && estimatedWidth > maxWidth) {
            maxFontSize--;
            estimatedWidth = calculateTextWidth(text, maxFontSize);
        }
        return maxFontSize;
    }

    private static double calculateTextWidth(String text, int fontSize) {
        double totalWidth = 0.0;
        for (char c : text.toCharArray()) {
            totalWidth += charWidths.getOrDefault(c, 0.0) * fontSize;
        }
        return totalWidth;
    }
}