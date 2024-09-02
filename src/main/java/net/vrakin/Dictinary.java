package net.vrakin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dictinary {

    private File file;

    private Map<String, String> map = new HashMap<String, String>();

    public Dictinary(File file) {
        this.file = file;

        read();
    }

    public void read() {
        map.clear();
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            while(br.ready()) {
                String line = br.readLine();
                String[] words = line.split("=");
                map.put(words[0], words[1]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bw.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictinary that = (Dictinary) o;
        return Objects.equals(file, that.file) && Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, map);
    }
}
