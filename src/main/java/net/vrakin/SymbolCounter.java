package net.vrakin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SymbolCounter {

    private File file;

    private Map<Character, Integer> map = new HashMap<Character, Integer>();

    public SymbolCounter(File file) {
        this.file = file;
    }

    public void read() {
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            while(br.ready()) {
                String line = br.readLine();
                for(int i = 0; i < line.length(); i++) {
                    if(map.containsKey(line.charAt(i))) {
                        map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                    }else {
                        map.put(line.charAt(i), 1);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map<Character, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Character, Integer> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SymbolCounter that = (SymbolCounter) o;
        return Objects.equals(file, that.file) && Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, map);
    }
}
