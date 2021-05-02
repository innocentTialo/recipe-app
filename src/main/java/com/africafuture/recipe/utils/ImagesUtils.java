package com.africafuture.recipe.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImagesUtils {

    public static byte[] getBytesOf(String imagePathName, String formatName) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(imagePathName));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, formatName, bos );
        return bos.toByteArray();
    }

}
