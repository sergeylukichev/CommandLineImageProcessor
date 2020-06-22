package de.telran;

import de.telran.entity.DownloadedImage;
import de.telran.entity.ImageDescriptor;
import de.telran.service.DownloadService;
import de.telran.service.FileService;
import de.telran.service.ImageDescriptorService;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private ImageDescriptorService imageDescriptorService;
    private DownloadService downloadService;
    private FileService fileService;
    //private DownloadService downloadService;
    //private ImageService imageService;
    //....

    public ImageProcessor(ImageDescriptorService imageDescriptorService,
                          DownloadService downloadService,
                          FileService fileService) {
        this.imageDescriptorService = imageDescriptorService;
        this.downloadService = downloadService;
        this.fileService = fileService;
    }

    public void doProcessing(String fileName) {

        List<ImageDescriptor> imageDescriptors = imageDescriptorService.getImageDescriptors(fileName);

        List<String> urls = imageDescriptors.stream().map(d -> d.getImageUrlName()).collect(Collectors.toList());

        List<DownloadedImage> downloadedImages = downloadService.downloadImages(urls);

        List<BufferedImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(DownloadedImage::isSuccessfull)
                .map(DownloadedImage::getImage)
                .collect(Collectors.toList());

        successfullyDownloadedImages.forEach(i -> fileService.saveImageAsFile(i));


        //call download service
        //call image service
        //

    }


    public static void main(String[] args) {

        String fileName = args[0];

        FileService fileService = new FileService();

        ImageDescriptorService imageDescriptorService = new ImageDescriptorService(fileService);

        DownloadService downloadService = new DownloadService();

        ImageProcessor processor = new ImageProcessor(imageDescriptorService, downloadService, fileService);

        processor.doProcessing(fileName);

    }
}
