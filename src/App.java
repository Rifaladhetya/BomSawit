public class App {
    public static void main(String[] args) {
        // Kita taruh Arrow1 di (0,0) menghadap KANAN
        Arrow arrow1 = new Arrow("KANAN", 0, 0);
        // Kita taruh Arrow2 di (10,0) tepat di depan Arrow1
        Arrow arrow2 = new Arrow("ATAS", 10, 0);

        System.out.println("--- TES TABRAKAN ---");
        
        // Cek apakah arrow1 terhalang oleh arrow2
        boolean isBlocked = arrow1.checkCollision(arrow2);
        
        arrow1.move(isBlocked); // Mencoba gerak
        arrow2.move(false);     // Arrow 2 gerak ke atas (tidak terhalang)
        
        // Setelah arrow2 pergi, arrow1 sekarang bisa gerak!
        System.out.println("\n--- SETELAH PENGHALANG PERGI ---");
        isBlocked = arrow1.checkCollision(arrow2);
        arrow1.move(isBlocked);
    }
}