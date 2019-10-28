package com.yufeng.singleton.serializable;

import java.io.*;

/**
 * @author yufeng
 * @date 2019/10/24 - 20:28
 */
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            Singleton myObject = Singleton.getInstance();

            FileOutputStream fosRef = new FileOutputStream(new File(
                    "myObjectFile.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileInputStream fisRef = new FileInputStream(new File(
                    "myObjectFile.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            Singleton myObject = (Singleton) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
