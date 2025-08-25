package TASK2;
import java.util.Arrays;

public class Scoreboard {
    private Player[] oyuncular;   // "arr" yerine daha açıklayıcı isim
    private int sayi;             // "size" yerine sayı tuttum

    // Başlangıçta 10 kişilik yer açıyorum (ileride gerekirse büyüteceğiz)
    public Scoreboard() {
        oyuncular = new Player[10];
        sayi = 0;
    }

    // Yeni oyuncu ekleme metodu
    public void addPlayer(Player p) {
        if (sayi == oyuncular.length) {
            // Dizi dolduğunda kapasiteyi 2 katına çıkarıyorum
            oyuncular = Arrays.copyOf(oyuncular, oyuncular.length * 2);
        }
        oyuncular[sayi] = p;
        sayi++;
    }

    // Skor tablosunu sıralama (şimdilik hızlı sıralama kullanıyorum)
    public void sortScoreboard() {
        if (sayi > 1) { // tek oyuncu varsa sıralamaya gerek yok
            quickSort(0, sayi - 1);
        }
    }

    // Hızlı sıralama algoritması (quicksort)
    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    // Diziyi pivot değerine göre ayırma
    private int partition(int low, int high) {
        int pivot = oyuncular[high].getScore(); // pivot: son elemanın skoru
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (oyuncular[j].getScore() >= pivot) {
                // "büyük eşit" kullandım çünkü skorların azalan şekilde sıralanması lazım
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    // İki elemanın yerini değiştirme
    private void swap(int i, int j) {
        Player tmp = oyuncular[i];
        oyuncular[i] = oyuncular[j];
        oyuncular[j] = tmp;
    }

    // Skor tablosunu ekrana yazdırma
    public void printScoreboard() {
        for (int i = 0; i < sayi; i++) {
            System.out.println(oyuncular[i]);
        }
    }
}
