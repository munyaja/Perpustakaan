/**
 * Write a description of class App here.
 *
 * @author Muny Safitri
 * @version 2021.07.11
 *
 * PROGRAM ini akan menyimpan data pada data.txt dan pinjambuku.txt.
 * berhati-hati dengan data tersebut agar tidak terjadi error program saat execute
 * user dapat meminjam  buku setelah registrasi 
 * User dapat melihat daftar nama meminjam buku
 * 
   */
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class App {

    static Module1 modul1;
    public static void main(String[] args) {

        Scanner obj=new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String fname,uni_id,uid,in,meminjam,name=null;
        int sem,choice =0;

        do{
            clearScreen();
        
            System.out.print("1. Daftar  \n2. Pinjam Buku \n3. Data Mahasiswa mendaftar\n4. Data Mahasiswa meminjam\n5. Keluar\nMasukkan pilihan: ");
            try{ 
                choice =obj.nextInt();
            }catch(InputMismatchException ex){ 
                System.out.print("\nAnda memasukkan input yang salah!\n");
                choice = 10;
            }
        
            if (choice == 1) {
                do{
                    
                    System.out.println("Enter jika petunjuk selanjutnya tidak keluar");
                    System.out.print("Masukkan nama mahasiswa: ");
                    if(name == null) name=obj.nextLine();
                    name=obj.nextLine();

                    System.out.print("Masukkan nama ayah: ");
                    fname=obj.nextLine();

                    System.out.print("Masukkan nama universitas (inisial): ");
                    uni_id=obj.nextLine();

                    System.out.print("Masukkan ID mahasiswa: ");
                    uid=obj.nextLine();

                    do{
                        try{
                            System.out.print("Semester: ");
                            sem=obj.nextInt();
                            if(sem <= 0 || sem > 16) System.out.println("Masukkan data dengan benar ");
                        }catch(InputMismatchException e){
                            System.out.println("Anda memasukkan data yang salah, nilai default 1 ");
                            
                            sem = 1;
                        }
                    }while(sem <= 0 || sem > 16);
                    
                    try{
                        int tgl;
                        do{
                            System.out.print("tanggal daftar: ");
                            obj.nextLine();meminjam =obj.nextLine();
                            tgl = Integer.valueOf(meminjam) ;
                            if(tgl <= 0 ||  tgl > 31) {
                                System.out.println("Masukkan data dengan benar ");
                            }
                        }while(tgl <= 0 ||  tgl > 31);
                    }catch(Exception e){
                        DateFormat dateFormat = new SimpleDateFormat("MM");
                        Date date = new Date();
                        System.out.println("Anda memasukkan data yang salah, nilai default "+dateFormat.format(date)); 
                        meminjam = dateFormat.format(date);
                        Enter();
                    }

                    System.out.print("Apakah anda ingin mengubah data(y/n)?");
                    in = input.nextLine();
                    in = in.toLowerCase();
                    clearScreen();
                     
                }while(in.charAt(0) == 'y' || !(in.charAt(0) == 'n'));

                modul1 =new Module1(name, fname, uid, uni_id, sem, meminjam);
                modul1.getData();
                Enter();    

            }else if(choice == 2){
                boolean lanjut;
                System.out.print("Masukkan nama anda:");
                String nama = input.nextLine();System.out.print("Enter");
                input.nextLine();

                Module2 obj2=new Module2(modul1,nama);
                clearScreen();

                if(obj2.cekNama() == true){
                    
                    obj2.chemistry();
                    obj2.physics();
                    obj2.biology();
                    obj2.informatics();
                    System.out.println("\nEnter");
                    Enter();
                    clearScreen();
                    System.out.print("\nIngin meminjam buku :\n(C)hemistry\n(P)hysics\n(B)iology\n(I)nformatics\nPilihan:");
                    String milih = input.next();
                    
                    lanjut = obj2.pilihan(milih);
                    
                    if(lanjut = true) obj2.menyimpanData();
                }
                Enter();
            }  
            else if(choice == 3){
                Module1 module1 =new Module1();
                module1.DataPendaftaran();
                Enter();
            }
            else if(choice == 4){
                Module2 moduleDua =new Module2();
                moduleDua.DataPinjaman();
                Enter();
            } 
            else{
                System.out.println("Anda memasukkan angka yang salah\n");
            }  
        }while(choice >0 && choice < 5);    
    }   

    /**
     * Method clearScreen
     * berfungsi untuk membersihkan layar
     */
    static void clearScreen(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\143");
            }
        }catch (Exception e){
            System.err.println("Tidak bisa clear screen");
        
        }
    }
     
    /**
     * Method Enter
     * untuk konfiramasi saja
     */
    static void Enter(){
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

}
