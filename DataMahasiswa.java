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

import java.lang.NullPointerException;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

public class DataMahasiswa {

    private String name,fname,uni_id,uid,sem,meminjam;
    private static String[] data = new String[100];
    
    DataMahasiswa(String name, String fname,String uni_id,String uid,String sem, String meminjam){
        this.name=name;
        this.fname = fname;
        this.uni_id = uni_id;
        this.uid = uid;
        this.sem = sem;
        this.meminjam = meminjam;
    }

    public void menyimpan(){
        try {
            File file = new File("data.txt");
            if (file.createNewFile()){
                System.out.println("File sudah dibuat!");
            }
        
        } catch (IOException e) {
            System.out.println("Data tidak dapat dibuat");
        }
        //membaca file seblumnya agar data sebelumnya tidak hilang
        try {
            File myFile = new File("data.txt");
            Scanner fileReader = new Scanner(myFile);
            int i=0;
            while(fileReader.hasNextLine()){
                data[i] = fileReader.nextLine();
                i++;
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
        }finally{
            System.out.println("\nData telah dibaca");  
        }
    }


    public void menulis(){
        try(
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
            Scanner fileReader = new Scanner("data.txt");
            ) { 
                bw.write(this.name.toUpperCase());
                bw.write(",");
                bw.write(this.fname);
                bw.write(",");
                bw.write(this.uni_id);
                bw.write(",");
                bw.write(this.uid);
                bw.write(",");
                bw.write(this.sem);
                bw.write(",");
                bw.write(this.meminjam);
                bw.write(",");
                if(data[0] != null) bw.newLine();//membuat baris baru
                
                try{ 
                    for(int i=0; i < data.length ; i++){//jika data sebalumnya telah dibuat, program akan menjalankan perulangan ini                    
                        bw.write(data[i]);
                        if(data[i+1].equals(null)) break;
                        bw.newLine();//membuat baris baru
                    } 
                }catch(NullPointerException ex){
                    System.out.println("\nData sudah disimpan!");
                    System.out.println("Anda dapat meminjam buku");

                    System.out.println("Silahkan execute program ini lagi ^^");
                }            
        } catch(IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
    }


}