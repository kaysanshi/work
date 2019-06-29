package cn.lexiang.singleservice.uitl;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author Qfeng
 * @Date 2019-03-27 22:51:57
 */
public class Tools {
    public static void save(MultipartFile file, String savepath) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("文件不能为空");
        }
        File dest = new File(savepath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        System.out.println("上传成功：" + savepath + " (" + file.getSize() + ")");
    }
}
