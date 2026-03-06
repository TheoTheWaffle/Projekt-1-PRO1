package pro1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // vstup a vystup bereme z korene projektu
        Path inputDir = Paths.get("input");
        Path outputDir = Paths.get("output");
        try {
            // kdyz output neexistuje, vytvori se
            Files.createDirectories(outputDir);
            // projedeme vsechny csv soubory z inputu
            try (DirectoryStream<Path> files = Files.newDirectoryStream(inputDir, "*.csv")) {
                for (Path src : files) {
                    // pro kazdy vstup udelame stejnojmenny vystup do output
                    processFile(src, outputDir.resolve(src.getFileName()));
                }
            }
        } catch (IOException e) {
            System.err.println("Chyba pri praci se slozkami: " + e.getMessage());
        }
    }

    private static void processFile(Path src, Path dst)
    {
        try {
            // nacte cely soubor jako seznam radku
            List<String> inputLines = Files.readAllLines(src);
            List<String> outputLines = new ArrayList<>();

            for (String rawLine : inputLines) {
                // orezeme mezery okolo, prazdne radky preskocime
                String line = rawLine.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // najde prvni oddelovac ; : nebo =
                int sep = findSeparator(line);
                if (sep < 0) {
                    continue;
                }

                // leva cast je jmeno, prava cast je vyraz
                String name = line.substring(0, sep).trim();
                String expression = line.substring(sep + 1).trim();

                try {
                    // spocita vyraz jako zlomek a ulozi vystup "Jmeno,vysledek"
                    Fraction result = Fraction.parse(expression);
                    outputLines.add(name + "," + result);
                } catch (RuntimeException e) {
                    // kdyz je radek spatne, jen ho preskocime a jedeme dal
                    System.err.println("Chyba parsovani na radku: " + rawLine);
                }
            }

            // zapise cely vystupni csv soubor
            Files.write(dst, outputLines);
        } catch (IOException e) {
            System.err.println("Chyba u souboru " + src.getFileName() + ": " + e.getMessage());
        }
    }

    private static int findSeparator(String line)
    {
        // projdeme text a vezmeme prvni separator
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ';' || c == ':' || c == '=') {
                return i;
            }
        }
        return -1;
    }
}
