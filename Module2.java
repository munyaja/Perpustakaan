/**
 * Write a description of class App here.
 *
 * @author Muny Safitri
 * @version 2021.07.11
 */
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Module2 {

    static String infor[]={"C/C++ language","Java language","Python language","How to build Website","Google Language","Git tutorial"};
    static String chem[]={"Organic chemistry","Physical chemistry","Bio chemistry","Inorganic chemistry","Polymer chemistry"};
    static String phy[]={"Mechanics","Dynamics","Solid State Physics","Astro Physics","Electromagnetism"};
    static String bio[]={"Zoology","Botany","Medical Science","Virologi","Ecosystem"};
    private static String[] Data = new String[1000];
    private Module1 modul;
    private String nama;
    private String bukuDiambil;
    private String meminjam;

    Module2(){ 
    }

    /**
     * Module2 Constructor
     *
     * @param modul A parameter
     * @param nama A parameter
     */
    Module2(Module1 modul, String nama){ 
        this.modul = modul;   
        this.nama = nama;
    }

    /**
     * Method chemistry
     * untuk menampilkan buku chemistry
     */
    public void chemistry(){
        System.out.println("\nBuku yang tersedia pada bagian Chemistry sebagai berikut:");
        for (int i=0; i< chem.length;i++){
            System.out.println((i+1)+". "+chem[i]);
        }
    }

    /**
     * Method physics
     * untuk menampilkan buku physic
     *
     */
    public void physics(){
        System.out.println("\nBuku yang tersedia pada bagian Physic sebagai berikut:");
        for(int j=0; j<phy.length;j++){
            System.out.println((j+1)+". "+phy[j]);
        }
    }

    /**
     * Method biology
     *U unyuk menampilkan buku biologi
     */
    public void biology(){
        System.out.println("\nBuku yang tersedia pada bagian Biology sebagai berikut:");
        for (int k=0;k< bio.length;k++){
            System.out.println((k+1)+". "+bio[k]);
        }
    }

    /**
     * Method informatics
     * Mmenampilkan buku informatika
     */
    public void informatics(){
        System.out.println("\nBuku yang tersedia pada bagian Computer Science sebagai berikut:");
        for (int k=0;k< infor.length;k++){
            System.out.println((k+1)+". "+infor[k]);
        }
    }

    /**
     * Method cekNama
     * dilakukan pengecekan apakah pengguna sudah registrasi atau tidak
     *
     * @return The return value
     */
    public boolean cekNama(){
        try{//membaca data.txt dengan delimeter koma
            String Data[] = new String[7];
            String data ;
            FileReader fileInput = new FileReader("data.txt");
            FileReader fileInput2 = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileInput);
            BufferedReader bufferedReader2 = new BufferedReader(fileInput2);
            Scanner scanner = new Scanner(bufferedReader2);
            scanner.useDelimiter(",");
            StringTokenizer stringToken;

            try{
                bufferedReader.mark(200);
                bufferedReader.reset();
                while(scanner.hasNext()){
                    int i = 0;
                    data = bufferedReader.readLine();
                    try{
                        stringToken = new StringTokenizer(data,",");

                        while(stringToken.hasMoreTokens()){
                            scanner.next();
                            Data[i] = stringToken.nextToken();
                            i++;
                        }
                        //jika nama user ada pada data.txt, maka akan menjalankan percabangan ini
                        if(this.nama.equalsIgnoreCase(Data[0])){
                            System.out.println("Selamat Datang " + getNama());
                            System.out.println("Anda telah mendaftar, Anda dapat meminjam buku");
                            return true;
                        }//jika tidak maka akan menjalankan percabangan ini
                        if(scanner.hasNext() == false ){
                            System.out.println("Daftar terlebih dahulu, nama anda tidak ditemukan di data");
                            return false;
                        }
                    }catch(Exception ex){}     
                }
            }catch(IOException ex){}
            
        }catch(FileNotFoundException ex){ return false; }
        return false;
    }

    /**
     * Method getNama
     * untuk mengembalikan nama 
     * @return The return value
     */
    public String getNama(){
        return this.nama;
    }

    /**
     * Method pilihan
     * bertujuan unutk menampilkan buku yang ada di perpuastakaan agar terdapat optional
     * dan jika user salah input maka program berakhir
     * @param milih A parameter
     */
    public boolean pilihan(String milih){
        int pilihan;
        
        Scanner inputan = new Scanner(System.in);
        if( milih.toLowerCase().charAt(0) == 'c' ){
            chemistry();
            System.out.print("Mau pinjam buku apa: ");
            pilihan = inputan.nextInt();
            for (int k=0;k< chem.length;k++){
                if(pilihan == (k+1)){
                    this.bukuDiambil =chem[k];
                    break;
                }else if(k+1 == chem.length){
                    System.out.println("TIDAK ADA"); 
                    return false;
                }
            }
        }else if(milih.toLowerCase().charAt(0) == 'p'){
            physics();
            System.out.print("Mau pinjam buku apa: ");
            pilihan = inputan.nextInt();
            for (int k = 0;k< phy.length;k++){
                if(pilihan == (k+1)){
                    this.bukuDiambil = phy[k];
                    break;
                }else if(k+1 == phy.length){
                    System.out.println("TIDAK ADA");
                    return false; 
                }
            }
        }else if(milih.toLowerCase().charAt(0) == 'b'){
            biology();
            System.out.print("Mau pinjam buku apa: ");
            pilihan = inputan.nextInt();
            for (int k=0;k< bio.length;k++){
                if(pilihan == (k+1)){
                    this.bukuDiambil = bio[k];
                    break;
                }else if(k+1 == bio.length){
                    System.out.println("TIDAK ADA"); 
                    return false;
                }
            }
        }else if(milih.toLowerCase().charAt(0) == 'i'){
            informatics();
            System.out.print("Mau pinjam buku apa: ");
            pilihan = inputan.nextInt();
            for (int k=0;k< infor.length;k++){
                if(pilihan == (k+1)){
                    this.bukuDiambil = infor[k];
                    break;
                }else if(k+1 == infor.length){
                    System.out.println("TIDAK ADA"); 
                    return false;
                }
            }
        }else{
            System.out.println("Inputan salah!");
            return false;
        }
        
        System.out.println("\nAnda meminjam buku " + this.bukuDiambil);
        return true;
        
    }

    public void menyimpanData(){
        DataPinjaman data = new DataPinjaman(this.nama,this.bukuDiambil);//clas komposisi
        data.membacaData();//menulis data
        data.menyimpan();
    }


    /**
     * Method DataPinjaman
     * menampilkan data pinjaman
     */
    public void DataPinjaman(){
        String Data2[] = new String[7];
        String data2 ;
        
        try{//.membaca file datapinjaman.txt
            FileReader fileInput = new FileReader("PinjamBuku.txt");
            FileReader fileInput2 = new FileReader("PinjamBuku.txt");
            BufferedReader bufferedReader = new BufferedReader(fileInput);
            BufferedReader bufferedReader2 = new BufferedReader(fileInput2);
            Scanner scanner = new Scanner(bufferedReader2);
            scanner.useDelimiter(",");
            StringTokenizer stringToken;

            try{
                bufferedReader.mark(200);
                bufferedReader.reset();

                System.out.print("\n==========================================================================================\n");
                System.out.printf("No\t||%15s\t||%15s\t||%15s\t||\n","Nama","bukuPinjam","tglPinjam");
                System.out.print("\n==========================================================================================\n");
                int nomor = 0;
                while(scanner.hasNext()){
                    int i = 0;
                    data2 = bufferedReader.readLine();
                    try{
                        stringToken = new StringTokenizer(data2,",");
                        while(stringToken.hasMoreTokens()){
                            scanner.next();
                            Data2[i] = stringToken.nextToken();
                            i++;
                        }
                        System.out.printf("%3d\t||",++nomor);
                        System.out.printf("%15s\t||",Data2[0]);
                        System.out.printf("%15s\t||",Data2[1]);
                        System.out.printf("%15s\t||",Data2[2]);
                        
                        System.out.println();
                        
                       
                    }catch(Exception ex){}

                    System.out.print("==========================================================================================\n");
                }
                
            }catch(IOException ex){System.out.println("Data Tidak ada");}
        }catch(FileNotFoundException ex){System.out.println("Data Tidak ada");}
    }
}