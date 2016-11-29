package render.ressources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by balthazar on 28/11/16.
 */
public class BufferedImageLoader {
    /**
     * Charge l'image depuis un fichier.
     * @param relativePath : le chemin relatif du fichier (relatif a l'emplacement de BufferedImageLoader.java)
     * @return : l'image correspondant au fichier
     * @throws IOException
     */
    public static BufferedImage loadImage(String relativePath) throws IOException { // TODO : chemin relatif et pas absolu !
        //URL url = BufferedImageLoader.class.getResource(relativePath);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(relativePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
