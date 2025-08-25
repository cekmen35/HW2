package ceng201.hw2.treasure;

import java.util.LinkedList;
import java.util.List;

public class TreasureInventory {
    private int size;
    /** Tüm kovaları ve içindeki değerleri yazdırır. */
    public void printInventory() {
        for (int i = 0; i < buckets.length; i++) {
            var chain = buckets[i];
            if (chain == null || chain.isEmpty()) continue;
            System.out.print("bucket[" + i + "]: ");
            boolean first = true;
            for (var e : chain) {
                if (!first) System.out.print(" -> ");
                System.out.print(e.value);
                first = false;
            }
            System.out.println();
        }
        if (size == 0) {
            System.out.println("(envanter boş)");
        }
    }


    // başlangıç kapasitesi (aslında HashMap'te de benzer bir şey var)
    private static final int DEFAULT_CAPACITY = 16;   // 2^4 = 16
    private static final double LOAD_FACTOR = 0.75;   // %75 dolunca genişletelim dedim

    // kovalarımız, her biri kendi linked list’ini tutacak
    private LinkedList<Entry>[] buckets;
    private int totalTreasures; // eleman sayısı (aslında "size" daha kısa ama daha açıklayıcı olsun diye değiştirdim)

    // entry yapısı -> key = id, value = treasure
    private static final class Entry {
        final int key;      // id (sabit çünkü id değişmez)
        Treasure value;     // treasure değişebilir diye final yapmadım

        Entry(int key, Treasure value) {
            this.key = key;
            this.value = value;
        }
    }

    // yapıcı metod
    @SuppressWarnings("unchecked")
    public TreasureInventory() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        // totalTreasures = 0; // gerek yok çünkü zaten default 0
    }

    /**
     * Treasure ekleme işlemi.
     * Eğer aynı id’den varsa güncelliyoruz.
     * return: true = yeni ekleme, false = güncelleme
     */
    public boolean addTreasure(Treasure t) {
        if (t == null) {
            throw new IllegalArgumentException("Treasure boş olamaz!");
        }
        checkCapacityBeforeInsert();

        int idx = bucketIndex(t.getId());   // hash index
        LinkedList<Entry> chain = getOrCreateChain(idx);

        // aynı id zaten varsa güncelle
        for (Entry e : chain) {
            if (e.key == t.getId()) {
                e.value = t;
                return false; // update oldu
            }
        }

        // yoksa ekle
        chain.add(new Entry(t.getId(), t));
        totalTreasures++;
        return true; // yeni ekleme
    }

    /** Id ile treasure bulur. Yoksa null döndürür. */
    public Treasure findTreasure(int id) {
        LinkedList<Entry> chain = chainAt(bucketIndex(id));
        if (chain == null) return null;

        for (Entry e : chain) {
            if (e.key == id) {
                return e.value;
            }
        }
        return null; // bulunamadı
    }

    /** Id ile treasure siler. Başarılıysa true döner. */
    public boolean removeTreasure(int id) {
        LinkedList<Entry> chain = chainAt(bucketIndex(id));
        if (chain == null) return false;

        for (var it = chain.iterator(); it.hasNext();) {
            Entry e = it.next();
            if (e.key == id) {
                it.remove(); // LinkedList iterator kullanmak güvenli
                totalTreasures--;
                return true;
            }
        }
        return false; // bulunamadı
    }

    // ---- yardımcı metotlar ----

    private int bucketIndex(int key) {
        // TODO: şimdilik basit hash, gerekirse iyileştirilebilir
        int h = key ^ (key >>> 16); // basit karıştırma
        return h & (buckets.length - 1);  // mod almadan maskeyle index
    }

    private LinkedList<Entry> getOrCreateChain(int idx) {
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }
        return buckets[idx];
    }

    private LinkedList<Entry> chainAt(int idx) {
        return buckets[idx];
    }

    private void checkCapacityBeforeInsert() {
        // biraz kaba hesap ama iş görüyor
        if ((totalTreasures + 1) > (int)(buckets.length * LOAD_FACTOR)) {
            // rehash yapmam lazım aslında ama şimdilik yazmadım

        }
    }
}



