package BAB_1;
public class main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("The 7 Habits of Highly Effective People", "Pengembangan Diri", 1500, 150);
        Buku buku2 = new Buku("Misteri Soliter", "Filosofi", 1200, 120);
        Buku buku3 = new Buku("Gadis Jeruk", "Filosofi", 500, 50);
        Buku buku4 = new Buku("Konspirasi Alam Semesta", "Novel", 500, 50);
        Buku buku5 = new Buku("Dunia Sophie", "Filosofi", 1000, 100);
        System.out.println(
            "Peminjaman buku "+buku1.getKategori()+"\n"+
            "Berjudul: "+buku1.getNamaBuku()+"\n"+
            "Selama 4 hari akan menghasilkan biaya sewa sebesar Rp"+buku1.getSewa(4)+".00,- \n"+
            "Apabila terlambat 2 hari, maka peminjam wajib membayar denda sebesar Rp"+buku1.getDenda(2)+".00,- \n"+
            "Dengan total biaya sebesar: "+(buku1.getSewa(4)+buku1.getDenda(2))+".00,- \n");
        System.out.println(
            "Peminjaman buku "+buku2.getKategori()+"\n"+
            "Berjudul: "+buku2.getNamaBuku()+"\n"+
            "Selama 2 hari akan menghasilkan biaya sewa sebesar Rp"+buku2.getSewa(2)+".00,- \n"+
            "Apabila terlambat 1 hari, maka peminjam wajib membayar denda sebesar Rp"+buku2.getDenda(1)+".00,- \n"+
            "Dengan total biaya sebesar: "+(buku2.getSewa(2)+buku2.getDenda(1))+".00,- \n");
        System.out.println(
            "Peminjaman buku "+buku3.getKategori()+"\n"+
            "Berjudul: "+buku3.getNamaBuku()+"\n"+
            "Selama 7 hari akan menghasilkan biaya sewa sebesar Rp"+buku3.getSewa(7)+".00,- \n"+
            "Apabila terlambat 10 hari, maka peminjam wajib membayar denda sebesar Rp"+buku3.getDenda(10)+".00,- \n"+
            "Dengan total biaya sebesar: "+(buku3.getSewa(7)+buku3.getDenda(10))+".00,- \n");
        System.out.println(
            "Peminjaman buku "+buku4.getKategori()+"\n"+
            "Berjudul: "+buku4.getNamaBuku()+"\n"+
            "Selama 5 hari akan menghasilkan biaya sewa sebesar Rp"+buku4.getSewa(5)+".00,- \n"+
            "Apabila terlambat 3 hari, maka peminjam wajib membayar denda sebesar Rp"+buku4.getDenda(3)+".00,- \n"+
            "Dengan total biaya sebesar: "+(buku4.getSewa(5)+buku4.getDenda(3))+".00,- \n");
        System.out.println(
            "Peminjaman buku "+buku5.getKategori()+"\n"+
            "Berjudul: "+buku5.getNamaBuku()+"\n"+
            "Selama 7 hari akan menghasilkan biaya sewa sebesar Rp"+buku5.getSewa(7)+".00,- \n"+
            "Apabila terlambat 6 hari, maka peminjam wajib membayar denda sebesar Rp"+buku5.getDenda(6)+".00,- \n"+
            "Dengan total biaya sebesar: "+(buku5.getSewa(7)+buku5.getDenda(6))+".00,- \n");
    }
}
