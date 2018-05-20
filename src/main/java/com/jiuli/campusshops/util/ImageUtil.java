package com.jiuli.campusshops.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


public class ImageUtil {
    public static File watermark = new File(PathUtil.getSourcePath("portrait.png"));
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static File transferToFile(CommonsMultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return file;
    }

    /**
     * 处理缩略图 , 并返回图片的相对值路径
     *
     * @param multipartFile
     * @param targetAddress
     * @return
     */
    public static String generateThumbnail(CommonsMultipartFile multipartFile, String targetAddress) {
        String extension = getFileExtension(multipartFile);
        targetAddress += LocalDateTime.now().format(format) + File.separator;
        String name = UUID.randomUUID().toString() + extension;
        String path = getAndMkdirPath(targetAddress) + name;
        File file = new File(path);
        logger.debug("current image path is :" + path);
        try {
            Thumbnails.of(multipartFile.getInputStream())
                    .size(300, 300)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return targetAddress + name;
    }

    public static String generateThumbnail(InputStream inputStream, String extension, String targetAddress) {
        targetAddress += LocalDateTime.now().format(format) + File.separator;
        String name = UUID.randomUUID().toString() + extension;
        String path = getAndMkdirPath(targetAddress) + name;
        File file = new File(path);
        logger.debug("current image path is :" + path);
        try {
            Thumbnails.of(inputStream)
                    .size(300, 300)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return targetAddress + name;
    }

    public static String generateThumbnail(File file, String targetAddress) {
        String extension = getFileExtension(file);
        targetAddress += LocalDateTime.now().format(format) + File.separator;
        String name = UUID.randomUUID().toString() + extension;
        String path = getAndMkdirPath(targetAddress) + name;
        File image = new File(path);
        logger.debug("current image path is :" + path);
        try {
            Thumbnails.of(file)
                    .size(300, 300)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(watermark), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(image);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return targetAddress + name;
    }


    private static String getAndMkdirPath(String targetAddress) {
        String parentPath = PathUtil.getImageBasePath() + targetAddress;
        File file = new File(parentPath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return parentPath;
    }

    private static String getFileExtension(CommonsMultipartFile multipartFile) {
        String filename = multipartFile.getOriginalFilename();
        return filename.substring(filename.lastIndexOf('.'));
    }

    public static String getFileExtension(File file) {
        String filename = file.getName();
        return filename.substring(filename.lastIndexOf('.'));
    }
}
