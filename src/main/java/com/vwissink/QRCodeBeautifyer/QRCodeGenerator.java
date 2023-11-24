package com.vwissink.QRCodeBeautifyer;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.w3c.dom.Document;

public class QRCodeGenerator {
    private final int width;
    private final int height;

    private String color = "white";
    private int whiteTextGradientIndex = 0;
    private int blackTextGradientIndex = 0;
    private int cycleCounter = 0;
    private int cycleThreshold = 5; // Number of cycles before switching text color

    private boolean saveAsPNG = false;
    private boolean saveAsSVG = false;

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
            {"rgb(30, 60, 114)", "rgb(42, 82, 152)"}     // Navy blue to royal blue
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
            {"rgb(210, 210, 255)", "rgb(180, 180, 255)"}   // Periwinkle to light periwinkle
    };

    public QRCodeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Change the number of cycles before switching text color, default is 5
    public void setCycleThreshold(int threshold) {
        this.cycleThreshold = threshold;
    }

    public void saveAsPNG() {
        saveAsPNG = true;
    }

    public void setSaveAsSVG() {
        saveAsSVG = true;
    }

    public void generateAndSaveQRCode(String url, String topLabel, String bottomLabel) throws Exception {
        generateAndSaveQRCode(url, topLabel, bottomLabel, "QRcode");
    }
    public void generateAndSaveQRCode(String url, String topLabel, String bottomLabel, String name) throws Exception {
        BitMatrix bitMatrix = generateQRCode(url, width, height);
        Document document = SVGDocumentCreator.createSVGDocument(width, height);
        SVGDocumentCreator.addGradientBackground(document, startColor, stopColor);
        SVGDocumentCreator.drawQRCode(bitMatrix, document, color);
        SVGDocumentCreator.addTextLabels(document, width, height, topLabel, bottomLabel, color);
        if (saveAsPNG) {
            SVGDocumentSaver.saveAsPNG(document, String.format("target/%s.png", name));
        }
        if (saveAsSVG) {
            SVGDocumentSaver.saveAsSVG(document, String.format("target/%s.svg", name));
        }
        cycleStartStopColors();
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
