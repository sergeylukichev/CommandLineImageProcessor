package de.telran.action;

import java.awt.image.BufferedImage;

public class PreviewImageAction implements ImageAction {
    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a preview");
        return null;
    }
}
