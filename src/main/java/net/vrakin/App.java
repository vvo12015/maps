package net.vrakin;

import java.io.File;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SymbolCounter symbolCounter = new SymbolCounter(new File("f1.txt"));
        symbolCounter.read();
        System.out.println(symbolCounter.getMap());
        Dictinary dictinary = new Dictinary(new File("f2.txt"));
        System.out.println(dictinary.getMap());
    }
}
