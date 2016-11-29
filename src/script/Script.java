package script;

import java.io.*;

/**
 * Created by balthazar on 29/11/16.
 */
public class Script {
    private String pathSource;
    private String executed;

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

    public boolean isValid () {
        return (pathSource != null && executed != null);
    }

    public String getExecutedCode () {
        return executed;
    }

    public void setExecutedCode (String newCode) {
        this.executed = newCode;
    }

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
