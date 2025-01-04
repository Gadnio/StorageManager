package dev.improve.manager;

import dev.improve.example.ExampleData;

import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class StorageManager {

    private CopyOnWriteArrayList<ExampleData> users = new CopyOnWriteArrayList<>();

    public void loadData(final File storageFile) {

        if (storageFile == null || !storageFile.exists()) {
            System.out.println("Storage file does not exist. Creating new one...");
            storageFile.getParentFile().mkdirs();
            try {
                storageFile.createNewFile();
            }
            catch (IOException e){
                System.out.println("An error occurred while loading data: ");
                e.printStackTrace();
            }

        }

        try(final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storageFile))){

            this.users = (CopyOnWriteArrayList<ExampleData>) ois.readObject();
            ois.close();
            System.out.println("Data loaded successfully.");

        }catch (IOException | ClassNotFoundException e){
            System.out.println("An error occurred while loading data: ");
            e.printStackTrace();
        }

    }

    public void saveData(final File storageFile, Object data) {

        if (storageFile == null || !storageFile.exists()) {
            System.out.println("Storage file does not exist. Creating new one...");
            storageFile.getParentFile().mkdirs();
            try {
                storageFile.createNewFile();
            }catch (IOException e){
                System.out.println("An error occurred while saving data: ");
                e.printStackTrace();
            }

        }

        try(final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storageFile))){
            oos.writeObject(data);
            oos.flush();
            System.out.println("Data saved successfully.");
        }catch (IOException e){
            System.out.println("An error occurred while saving data: ");
            e.printStackTrace();
        }

    }

    public CopyOnWriteArrayList<ExampleData> getUsers() {
        return users;
    }

}
