package com.vwissink.qrcodebeautifyer;
import com.vwissink.QRCodeBeautifyer.QRCodeGenerator;
import com.vwissink.QRCodeBeautifyer.SVGDocumentSaver;

public class Main {
    public static void main(String[] args) {
        try {
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
            qrCodeGenerator.setCycleThreshold(3);

            String[][] gradientsBlackText = new String[][]{
                    {"rgb(118, 184, 255)", "rgb(84, 166, 255)"},  // blue 400 -> blue 500
                    {"rgb(89, 226, 124)", "rgb(48, 219, 91)"},  // green 400 -> green 500
                    {"rgb(125, 235, 255)", "rgb(93, 230, 255)"},  // petrol 400 -> petrol 500
                    {"rgb(225, 165, 255)", "rgb(218, 143, 255)"},  // purple 400 -> purple 500
                    {"rgb(255, 146, 141)", "rgb(255, 119, 112)"},  // red 400 -> red 500
                    {"rgb(255, 221, 81)", "rgb(255, 212, 38)"}  // amber 400 -> amber 500
            };

            String[][] gradientsWhiteText = new String[][]{
                    {"rgb(56, 133, 211)", "rgb(6, 103, 200)"},  // blue 400 -> blue 500
                    {"rgb(74, 147, 92)", "rgb(29, 120, 51)"},  // green 400 -> green 500
                    {"rgb(52, 141, 161)", "rgb(1, 113, 142)"},  // petrol 400 -> petrol 600
                    {"rgb(161, 105, 188)", "rgb(137, 68, 171)"},  // purple 400 -> purple 600
                    {"rgb(206, 51, 66)", "rgb(194, 0, 19)"},  // red 400 -> red 600
                    {"rgb(181, 122, 68)", "rgb(162, 89, 21)"}  // amber 400 -> amber 600
            };


            qrCodeGenerator.setGradientsBlackText(gradientsBlackText);
            qrCodeGenerator.setGradientsWhiteText(gradientsWhiteText);

            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "", "QRcode1");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "", "QRcode2");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "", "QRcode3");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "", "QRcode4");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "", "QRcode5");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR", "QRcode6");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR", "QRcode7");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR", "QRcode8");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode9");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode10");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode11");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode12");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode13");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Beautiful", "QR Codes", "QRcode14");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", "In", "QRcode15");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", "In", "QRcode16");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", "In", "QRcode17");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", "In", "QRcode18");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode19");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode20");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode21");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode22");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode23");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode24");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Generated", " In Java", "QRcode25");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In", "QRcode26");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In", "QRcode27");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In", "QRcode28");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In", "QRcode29");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In", "QRcode30");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A", "QRcode31");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A", "QRcode32");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A", "QRcode33");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single ", "QRcode34");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single ", "QRcode35");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single ", "QRcode36");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single ", "QRcode37");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode38");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode39");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode40");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode41");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode42");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", "", "QRcode43");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode44");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", "", "QRcode45");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode46");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", "", "QRcode47");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode48");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode49");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Made", "In A Single Line", "QRcode50");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly", "", "QRcode51");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly", "", "QRcode52");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly", "", "QRcode53");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "", "QRcode54");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "", "QRcode55");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "", "QRcode56");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode57");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode58");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode59");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode60");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode61");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode62");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly", "QRcode63");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode64");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode65");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode66");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode67");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode68");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode69");
            qrCodeGenerator.generateAndSaveQRCodeAsPNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Effortlessly Crafted", "Instantly Delivered", "QRcode70");


            SVGDocumentSaver.saveOutputStreamAsPNG(qrCodeGenerator.genereateQRCodePNG("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", ""),"latestCode");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}