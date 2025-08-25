package TASK3;
public class RoutePlanner {
    private HuntRoute[] yollar;   // arr yerine daha açıklayıcı olsun dedim
    private int sayi;             // "size" yerine Türkçe tuttum
    private static final int BASLANGIC_KAPASITE = 10;

    // Başlangıçta belli kapasiteyle başlıyoruz (10 yeter mi emin değilim ama şimdilik kalsın)
    public RoutePlanner() {
        yollar = new HuntRoute[BASLANGIC_KAPASITE];
        sayi = 0;
    }

    // Yeni rota ekleme metodu
    public void addRoute(HuntRoute r) {
        if (sayi == yollar.length) {
            // kapasiteyi iki katına çıkarıyorum
            HuntRoute[] yeniDizi = new HuntRoute[yollar.length * 2];
            System.arraycopy(yollar, 0, yeniDizi, 0, yollar.length);
            yollar = yeniDizi;
        }
        yollar[sayi] = r;
        sayi++;
    }

    // Rotayı sıralama fonksiyonu (artan mesafeye göre)
    public void sortRoutes() {
        if (sayi > 1) {
            mergeSort(0, sayi - 1);
        }
    }

    // MergeSort algoritması (klasik)
    private void mergeSort(int sol, int sag) {
        if (sol < sag) {
            int orta = (sol + sag) / 2;
            mergeSort(sol, orta);
            mergeSort(orta + 1, sag);
            merge(sol, orta, sag);
        }
    }

    // İki parçayı birleştirme (merge)
    private void merge(int sol, int orta, int sag) {
        int n1 = orta - sol + 1;
        int n2 = sag - orta;

        HuntRoute[] L = new HuntRoute[n1];
        HuntRoute[] R = new HuntRoute[n2];

        // Soldaki parçayı kopyala
        System.arraycopy(yollar, sol, L, 0, n1);
        // Sağdaki parçayı kopyala
        System.arraycopy(yollar, orta + 1, R, 0, n2);

        int i = 0, j = 0, k = sol;

        // Karşılaştırıp küçük olanı önce ekliyorum (artan sıralama için)
        while (i < n1 && j < n2) {
            if (L[i].distance <= R[j].distance) {
                yollar[k++] = L[i++];
            } else {
                yollar[k++] = R[j++];
            }
        }

        // Kalan elemanları ekle
        while (i < n1) yollar[k++] = L[i++];
        while (j < n2) yollar[k++] = R[j++];
    }

    // Rotayı ekrana yazdırma
    public void printRoutes() {
        for (int i = 0; i < sayi; i++) {
            // Belki daha güzel formatlanabilir ama şimdilik böyle kalsın
            System.out.println(
                    yollar[i].treasureId + " – " + yollar[i].distance + " – " + yollar[i].points
            );
        }
    }

    // Küçük bir test senaryosu
    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Elle birkaç rota ekledim (normalde dosyadan okunabilir)
        planner.addRoute(new HuntRoute(1, 12.5, 100));
        planner.addRoute(new HuntRoute(2, 5.2, 50));
        planner.addRoute(new HuntRoute(3, 20.0, 200));
        planner.addRoute(new HuntRoute(4, 7.7, 80));
        planner.addRoute(new HuntRoute(5, 15.3, 150));
        planner.addRoute(new HuntRoute(6, 3.0, 40));
        planner.addRoute(new HuntRoute(7, 11.1, 120));
        planner.addRoute(new HuntRoute(8, 9.5, 90));

        // Sıralama işlemi
        planner.sortRoutes();

        // Çıktıyı ekrana yazdırıyorum
        planner.printRoutes();
    }
}
