package de.telran;

import de.telran.entity.ActionableImage;
import de.telran.entity.ImageDescriptor;
import de.telran.factory.ImageActionFactory;
import de.telran.service.DownloadService;
import de.telran.service.FileService;
import de.telran.service.ImageDescriptorService;
import de.telran.service.ImageService;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private ImageDescriptorService imageDescriptorService;
    private DownloadService downloadService;
    private ImageService imageService;
    private FileService fileService;

    public ImageProcessor(ImageDescriptorService imageDescriptorService,
                          DownloadService downloadService,
                          ImageService imageService,
                          FileService fileService) {
        this.imageDescriptorService = imageDescriptorService;
        this.downloadService = downloadService;
        this.imageService = imageService;
        this.fileService = fileService;
    }

    public void doProcessing(String fileName) {

        List<ImageDescriptor> imageDescriptors = imageDescriptorService.getImageDescriptors(fileName);

        List<ActionableImage> actionableImages = imageDescriptors
                .stream()
                .map(i -> new ActionableImage(null, false, i.getImageUrlName(), i.getActionName()))
                .collect(Collectors.toList());

        List<ActionableImage> downloadedImages = downloadService.downloadImages(actionableImages);

        List<ActionableImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(ActionableImage::isSuccessfull)
                .collect(Collectors.toList());

        List<ActionableImage> processedImages = successfullyDownloadedImages
                .stream()
                .map(i -> imageService.processImage(i))
                .collect(Collectors.toList());

        processedImages.forEach(i -> fileService.saveImageAsFile(i));

    }


    public static void main(String[] args) {

        String fileName = args[0];

        FileService fileService = new FileService();

        ImageDescriptorService imageDescriptorService = new ImageDescriptorService(fileService);

        DownloadService downloadService = new DownloadService();

        ImageService imageService = new ImageService(new ImageActionFactory());

        ImageProcessor processor = new ImageProcessor(imageDescriptorService, downloadService, imageService, fileService);

        processor.doProcessing(fileName);

    }
}
