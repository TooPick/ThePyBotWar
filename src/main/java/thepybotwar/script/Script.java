package thepybotwar.script;

import java.io.*;

/**
 * Classe qui représente un script exécuté par un tank
 *
 * @author Balthazar
 * @version 1.0
 */
public class Script {
    private String pathSource;
    private String executed;

    /**
     * Constructor
     *
     * @param path Chemin du fichier Python
     */
    public Script (String path) {
        this.pathSource = path;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            executed = sb.toString();
        } catch (IOException e) {
            this.pathSource = null;
            this.executed = null;
        }

    }

    /**
     * Renvoi si le script à bien été chargé
     *
     * @return Script chargé : true, sinon : false
     */
    public boolean isValid () {
        return (pathSource != null && executed != null);
    }

    /**
     * Renvoi le code qui peut être exécuté par JPython
     *
     * @return Code exécutable
     */
    public String getExecutedCode () {
        return executed;
    }

    /**
     * Défini le code qui peut être exécuté par JPython
     *
     * @param newCode Code exécutable
     */
    public void setExecutedCode (String newCode) {
        this.executed = newCode;
    }

    /**
     * Sauvegarde le contenu du script dans le fichier Python
     */
    public void save () {
        File fold = new File(pathSource);
        fold.delete();
        File fnew = new File(pathSource);

        try {
            FileWriter fw = new FileWriter(fnew, false);
            fw.write(executed);
            fw.close();
        } catch (IOException e) {

        }

    }
}
