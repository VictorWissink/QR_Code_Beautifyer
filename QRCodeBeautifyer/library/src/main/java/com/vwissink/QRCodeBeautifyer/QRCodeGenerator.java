package com.vwissink.QRCodeBeautifyer;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;

import static com.vwissink.QRCodeBeautifyer.SVGDocumentSaver.createPNGFromSVG;

public class QRCodeGenerator {
    private int width = 400;
    private int height = 450;

    private String color = "white";
    private int whiteTextGradientIndex = 0;
    private int blackTextGradientIndex = 0;
    private int cycleCounter = 0;
    private int cycleThreshold = 5; // Number of cycles before switching text color
    private String startColor = "rgb(253,200,48)";
    private String stopColor = "rgb(243,115,53)";

    String[][] gradientsWhiteText = new String[][]{
            {"rgb(52, 143, 80)", "rgb(86, 180, 211)"},  // Green to light blue
            {"rgb(136, 21, 204)", "rgb(233, 64, 87)"},  // Purple to pink
            {"rgb(17, 153, 142)", "rgb(56, 239, 125)"}, // Teal to light green
            {"rgb(162, 171, 88)", "rgb(204, 221, 155)"}, // Olive green to light olive
            {"rgb(131, 77, 155)", "rgb(208, 78, 214)"},  // Dark purple to pink purple
            {"rgb(242, 112, 156)", "rgb(255, 148, 114)"}, // Pink to peach
            {"rgb(34, 193, 195)", "rgb(253, 187, 45)"},  // Blue to yellow
            {"rgb(195, 20, 50)", "rgb(36, 11, 54)"},     // Red to dark purple
            {"rgb(0, 4, 40)", "rgb(0, 78, 146)"},        // Dark blue to medium blue
            {"rgb(255, 75, 31)", "rgb(255, 144, 104)"},  // Bright red to light red
            {"rgb(67, 198, 172)", "rgb(248, 255, 174)"}, // Turquoise to light yellow
            {"rgb(106, 48, 147)", "rgb(160, 68, 255)"},  // Indigo to violet
            {"rgb(192, 57, 43)", "rgb(142, 68, 173)"},   // Red to dark purple
            {"rgb(30, 60, 114)", "rgb(42, 82, 152)"},     // Navy blue to royal blue
            {"rgb(0, 176, 155)", "rgb(150, 201, 61)"},       // Teal to lime green
            {"rgb(229, 57, 53)", "rgb(227, 93, 91)"},        // Deep red to soft red
            {"rgb(255, 175, 189)", "rgb(255, 195, 160)"},    // Pink to peach
            {"rgb(67, 160, 71)", "rgb(102, 187, 106)"},      // Dark green to medium green
            {"rgb(179, 136, 255)", "rgb(248, 187, 208)"},    // Light purple to pink
            {"rgb(41, 121, 255)", "rgb(0, 229, 255)"},       // Blue to cyan
            {"rgb(123, 31, 162)", "rgb(32, 76, 255)"},       // Purple to blue
            {"rgb(255, 183, 77)", "rgb(255, 234, 0)"},       // Orange to yellow
            {"rgb(33, 33, 33)", "rgb(97, 97, 97)"},          // Dark grey to grey
            {"rgb(141, 110, 99)", "rgb(215, 204, 200)"},     // Brown to light brown
            {"rgb(29, 233, 182)", "rgb(0, 191, 165)"},       // Turquoise to teal
            {"rgb(255, 110, 64)", "rgb(255, 61, 0)"},        // Bright orange to dark orange
            {"rgb(124, 77, 255)", "rgb(101, 31, 255)"},      // Indigo to deep purple
            {"rgb(213, 0, 249)", "rgb(255, 64, 129)"},       // Magenta to bright pink
            {"rgb(48, 79, 254)", "rgb(0, 145, 234)"}         // Royal blue to sky blue

    };
    String[][] gradientsBlackText = new String[][]{
            {"rgb(255, 255, 200)", "rgb(255, 250, 150)"},  // Light yellow to pale yellow
            {"rgb(200, 250, 255)", "rgb(150, 200, 255)"},  // Light blue to soft blue
            {"rgb(255, 220, 200)", "rgb(255, 180, 150)"},  // Pale orange to light orange
            {"rgb(210, 255, 210)", "rgb(180, 255, 180)"},  // Soft green to light green
            {"rgb(255, 225, 255)", "rgb(255, 200, 255)"},  // Pale pink to soft pink
            {"rgb(200, 200, 255)", "rgb(150, 150, 255)"},  // Soft purple to light purple
            {"rgb(255, 255, 255)", "rgb(230, 230, 230)"},  // White to light gray
            {"rgb(255, 235, 205)", "rgb(245, 215, 185)"},  // Beige to light beige
            {"rgb(230, 250, 230)", "rgb(200, 230, 200)"},  // Mint green to pale green
            {"rgb(255, 240, 230)", "rgb(255, 220, 210)"},  // Peach to light peach
            {"rgb(220, 240, 255)", "rgb(190, 220, 255)"},  // Sky blue to light sky blue
            {"rgb(240, 255, 240)", "rgb(210, 255, 210)"},  // Pale mint to light mint
            {"rgb(255, 210, 255)", "rgb(255, 180, 255)"},  // Lavender to light lavender
            {"rgb(210, 210, 255)", "rgb(180, 180, 255)"},   // Periwinkle to light periwinkle
            {"rgb(240, 238, 235)", "rgb(214, 211, 208)"}, // Off-white to light grey
            {"rgb(207, 216, 220)", "rgb(176, 190, 197)"}, // Light blue-grey to grey
            {"rgb(255, 253, 231)", "rgb(255, 249, 196)"}, // Pale yellow to light yellow
            {"rgb(224, 247, 250)", "rgb(179, 229, 252)"}, // Very light blue to light blue
            {"rgb(240, 225, 215)", "rgb(215, 204, 200)"}, // Light beige to pale beige
            {"rgb(230, 238, 156)", "rgb(205, 220, 57)"}, // Light lime to lime green
            {"rgb(207, 216, 220)", "rgb(144, 202, 249)"}, // Light blue-grey to light blue
            {"rgb(255, 235, 238)", "rgb(255, 205, 210)"}, // Very light pink to light pink
            {"rgb(244, 143, 177)", "rgb(240, 98, 146)"}, // Soft pink to medium pink
            {"rgb(224, 224, 224)", "rgb(189, 189, 189)"}, // Light grey to medium grey
            {"rgb(197, 225, 165)", "rgb(174, 213, 129)"}, // Light green to medium green
            {"rgb(255, 248, 225)", "rgb(255, 241, 189)"}, // Pale cream to light cream
            {"rgb(232, 234, 246)", "rgb(197, 202, 233)"}, // Light lavender to lavender
            {"rgb(215, 204, 200)", "rgb(188, 170, 164)"}, // Light brown to medium brown
            {"rgb(224, 247, 250)", "rgb(144, 202, 249)"} // Light sky blue to sky blue

    };

    public QRCodeGenerator() {
    }

    // Change the number of cycles before switching text color, default is 5
    public void setCycleThreshold(int threshold) {
        this.cycleThreshold = threshold;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generateAndSaveQRCodeAsPNG(String url, String topLabel, String bottomLabel, String name) throws Exception {
        Document qrCodeCard = drawQRCodeCard(url, topLabel, bottomLabel);
        SVGDocumentSaver.saveSVGAsPNG(qrCodeCard, String.format("target/%s.png", name));
    }

    public void generateAndSaveQRCodeAsSVG(String url, String topLabel, String bottomLabel, String name) throws Exception {
        Document qrCodeCard = drawQRCodeCard(url, topLabel, bottomLabel);
        SVGDocumentSaver.saveAsSVG(qrCodeCard, String.format("target/%s.svg", name));
    }

    public byte[] genereateQRCodePNG(String url, String topLabel, String bottomLabel) throws Exception {
        Document qrCodeCard = drawQRCodeCard(url, topLabel, bottomLabel);
        return SVGDocumentSaver.createPNGFromSVG(qrCodeCard);
    }

    private Document drawQRCodeCard(String url, String topLabel, String bottomLabel) throws Exception {
        BitMatrix bitMatrix = generateQRCode(url, width, height);
        Document document = SVGDocumentCreator.createSVGDocument(width, height);
        SVGDocumentCreator.addGradientBackground(document, startColor, stopColor);
        SVGDocumentCreator.drawQRCode(bitMatrix, document, color);
        SVGDocumentCreator.addTextLabels(document, width, height, topLabel, bottomLabel, color);
        cycleStartStopColors();
        return document;
    }

    private static BitMatrix generateQRCode(String url, int width, int height) throws Exception {
        return new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
    }

    private void cycleStartStopColors() {
        if (cycleCounter < cycleThreshold) {
            // Cycling through gradients for white text
            startColor = gradientsWhiteText[whiteTextGradientIndex][0];
            stopColor = gradientsWhiteText[whiteTextGradientIndex][1];
            whiteTextGradientIndex = (whiteTextGradientIndex + 1) % gradientsWhiteText.length;
            color = "white";
        } else {
            // Cycling through gradients for black text
            startColor = gradientsBlackText[blackTextGradientIndex][0];
            stopColor = gradientsBlackText[blackTextGradientIndex][1];
            blackTextGradientIndex = (blackTextGradientIndex + 1) % gradientsBlackText.length;
            color = "black";
        }

        cycleCounter++;
        if (cycleCounter == cycleThreshold * 2) {
            // Reset the counter after completing both white and black text cycles
            cycleCounter = 0;
        }
    }
}
