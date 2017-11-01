package cn.mrpei.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * The type Api upload controller.
 * TODO 上传独立测试类 无实际作用  生产环境删除
 */
@RestController
@RequestMapping("/api/img")
public class ApiUploadController {

    /**
     * Upload string.
     *
     * @param filedata the filedata
     * @return the string
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile filedata){
        System.out.println(filedata);
        // 获取图片的文件名
        String fileName = filedata.getOriginalFilename();
        // 获取图片的扩展名
        String extensionName = fileName
                .substring(fileName.lastIndexOf(".") + 1);
        // 新的图片文件名 = 获取时间戳+"."图片扩展名
        String newFileName = String.valueOf(System.currentTimeMillis())
                + "." + extensionName;
        saveFile(newFileName, filedata);

        return "222";
    }

    private void saveFile(String newFileName, MultipartFile filedata) {
        // TODO Auto-generated method stub
        // 根据配置文件获取服务器图片存放路径
        String picDir = "F:\\hello";

        String saveFilePath = picDir;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + "\\"
                    + newFileName);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
