package cn.mrpei.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {


    /**
     * Upload img string.
     *文件上传方法
     * @param file     the file
     * @param rootPath the root path
     * @return the string
     */
    public static String uploadFile(MultipartFile file, String rootPath) {
        String fileName = new Date().getTime() + file.getOriginalFilename();
        File tagetFile = new File(rootPath,fileName);
        //System.out.println("taret:"+ tagetFile);
        if (!tagetFile.exists()){
            tagetFile.mkdirs();
        }
        try {
            file.transferTo(tagetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return tagetFile.getAbsolutePath();
        return fileName;
    }


}
