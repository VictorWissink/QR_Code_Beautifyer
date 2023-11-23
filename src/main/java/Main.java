
public class Main {
    public static void main(String[] args) {

        try {
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator( 400, 450);
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode2");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode3");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode4");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode5");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode6");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode7");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode8");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode9");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode10");
            qrCodeGenerator.generateAndSaveQRCode("https://www.victorwissink.com", "Bund iOS", "Scan me!", "QRcode11");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}