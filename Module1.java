/**
 * Write a description of class App here.
 *
 * @author Muny Safitri
 * @version 2021.07.11
 */
import java.lang.NullPointerException;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Module1 {

    private String name,fname,uni_id,uid,sem,meminjam;
    
    Module1(){

    }

    /**
     * Module1 Constructor
     *
     * @param name A parameter
     * @param fname A parameter
     * @param uni_id A parameter
     * @param uid A parameter
     * @param sem A parameter
     * @param meminjam A parameter
     */
    Module1( String name,String fname, String uni_id, String uid,int sem ,String meminjam){
        this.name=name;
        this.fname = fname;
        this.uni_id = uni_id;
        this.uid = uid;
        this.sem = String.valueOf(sem);
        this.meminjam = meminjam;
    }

    /**
     * Method getData
     * berfungsi untuk menampilkan nilai data
     */
    public void getData(){
        System.out.println("Nama Mahasiswa : "+this.name);
        System.out.println("Nama Ayah : "+this.fname);
        System.out.println("ID universitas : "+this.uni_id);
        System.out.println("ID Mahasiswa : "+ this.uid);
        System.out.println("Semester : "+this.sem);
        System.out.println("tgl meminjam : "+this.meminjam);
        System.out.println("\nKembalikan buku setelah 7 hari meminjam ");
        menyimpanData();
    }   

    /**
     * Method menyimpanData
     *berfungsi untuk menyimpan data
     */
    public void menyimpanData(){
        //Membuat file teks dengan nama data.txt baru jika data tidak ditemuka
        DataMahasiswa data = new DataMahasiswa(name,fname,uni_id,uid,sem,meminjam);
        data.menyimpan();
        data.menulis(); //menulis data ke data.txt
    }
    
    /**
     * Method DataPendaftaran
     * menampilan data mahasiswa yan telah mendaftar
     */
    public void DataPendaftaran(){
        String Data2[] = new String[7];
        String data2 ;

        try{//bertujuan untuk membaca data.txt dan memisahkan setiap nilai ke sebuah variabel dengan delimeter koma(,)
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

                System.out.print("\n=========================================================================================================================================================\n");
                System.out.printf("No\t||%15s\t||%15s\t||%15s\t||%15s\t||%15s\t||%15s\t||\n","Nama","Ayah","Univ","IDM","Sems","tglDaftar");
                System.out.print("=========================================================================================================================================================\n");
                int nomor = 0;
                //menampilkan isi data pada data.txt
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
                        System.out.printf("%15s\t||",Data2[3]);
                        System.out.printf("%15s\t||",Data2[4]);
                        System.out.printf("%15s\t||",Data2[5]);
                        System.out.println();
                       
                    }catch(Exception ex){}
                    System.out.print("=========================================================================================================================================================\n");
                }
            }catch(IOException ex){System.out.println("Data Tidak ada");}
        }catch(FileNotFoundException ex){
            System.out.println("Data Tidak ada");
        }
    } 
}