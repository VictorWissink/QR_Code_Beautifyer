
public class Main {
    public static void main(String[] args) {

        try {
            QRCodeGenerator qrCodeGenerator = new QRCodeGenerator( 400, 450);
            qrCodeGenerator.setCycleThreshold(5);
            qrCodeGenerator.saveAsPNG();

            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "Bund Android", "Bund next column offline");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode2");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode3");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode4");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode5");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode6");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode7");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode8");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode9");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode10");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode11");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode12");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode13");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode14");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode15");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode16");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode17");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode18");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode19");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode20");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode21");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode22");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode23");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode24");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode25");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode26");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode27");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode28");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode29");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode30");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "App Flavor", "Backend Name here", "QRcode31");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", "This only has one text", "onlyBottom");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "This only has one text", "", "onlyTop");
            qrCodeGenerator.generateAndSaveQRCode("wire://access/?config=https://prod-nginz-https.wire.com/deeplink.json", "", "", "none");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}