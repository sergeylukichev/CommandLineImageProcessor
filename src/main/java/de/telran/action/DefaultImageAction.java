package de.telran.action;

import java.awt.image.BufferedImage;

public class DefaultImageAction implements ImageAction {
    @Override
    public BufferedImage doAction(BufferedImage source) throws Exception {
        System.out.println("Action not supported");
        throw new Exception("Action not supported");
    }
}
