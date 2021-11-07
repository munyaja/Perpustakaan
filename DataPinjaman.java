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

public class DataPinjaman{
    private String nama;
    private String bukuDiambil;
    private String meminjam;
    private static String[] data = new String[100];

    DataPinjaman(String nama, String bukuDiambil){ 
        this.bukuDiambil = bukuDiambil;   
        this.nama = nama;
        //this.meminjam = meminjam;
    }

    public void membacaData(){
         
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        this.meminjam = dateFormat.format(date);

        // membaca file, jika pinjambuku.txt belum dibuat, maka akan diba=uat secara automatis
        File myFile = new File("PinjamBuku.txt");
            try{
                Scanner fileReader = new Scanner(myFile);
                if (myFile.createNewFile()){
                System.out.println("File sudah dibuat!");
                }
                int i=0;
                while(fileReader.hasNextLine()){
                    data[i] = fileReader.nextLine();
                    i++;
                }
            }catch(Exception e){
                    
        }finally{
            System.out.println("\nData telah dibaca");  
        }
        //menulis nilai data tersebut ke pinjambuku.txt dengan pemisah koma
    }

    public void menyimpan(){
        try(
            BufferedWriter bw = new BufferedWriter(new FileWriter("PinjamBuku.txt"));
            Scanner fileReader = new Scanner("PinjamBuku.txt");
            ) { 
                bw.write(this.nama);
                bw.write(",");
                bw.write(this.bukuDiambil);
                bw.write(",");
                bw.write(meminjam);
                bw.write(",");
                if(data[0] != null) bw.newLine();
                    
                try{ //akan masuk perulangan jika data seblumnya sudah pernah ditulis di data pinjambuku.txt
                    for(int i=0; i < data.length ; i++){
                        bw.write(data[i].toUpperCase());
                        if(data[i+1].equals(null)) break;
                        bw.newLine();
                    } 
                }catch(NullPointerException ex){
                    System.out.println("\nData sudah disimpan!");
                    System.out.println("Terimakasih sudah meminjam ^^");
                }
                
        } catch(IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
    }

    

}