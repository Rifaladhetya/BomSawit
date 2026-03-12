public class Arrow {
    private String direction; 
    private int x, y;       
    private boolean isActive; 

    public Arrow(String direction, int startX, int startY) {
        this.direction = direction.toUpperCase();
        this.x = startX;
        this.y = startY;
        this.isActive = true;
    }

    // METHOD BARU: Mengecek apakah koordinat kita akan menabrak panah lain
    public boolean checkCollision(Arrow other) {
        if (!this.isActive || !other.isActive) return false;

        // Cek posisi satu langkah ke depan berdasarkan arah
        int nextX = this.x;
        int nextY = this.y;

        switch (direction) {
            case "KANAN": nextX += 10; break;
            case "KIRI":  nextX -= 10; break;
            case "ATAS":  nextY += 10; break;
            case "BAWAH": nextY -= 10; break;
        }

        // Jika posisi depan kita sama dengan posisi panah lain, berarti TABRAKAN
        return (nextX == other.getX() && nextY == other.getY());
    }

    public void move(boolean blocked) {
        if (!isActive) return;
        
        if (blocked) {
            System.out.println("Arrow " + direction + " TERHALANG! Tidak bisa gerak.");
        } else {
            // Logika gerak yang sama seperti sebelumnya
            switch (direction) {
                case "KANAN": x += 10; break;
                case "KIRI":  x -= 10; break;
                case "ATAS":  y += 10; break;
                case "BAWAH": y -= 10; break;
            }
            if (x > 100 || x < -100 || y > 100 || y < -100) isActive = false;
            System.out.println("Arrow " + direction + " berhasil bergeser.");
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void showStatus() {
        System.out.println("Arrow " + direction + " di (" + x + "," + y + ") | Aktif: " + isActive);
    }
}