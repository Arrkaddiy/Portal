package my.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadpath;

    public String addPicture(MultipartFile file) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadpath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidfile = UUID.randomUUID().toString();
            String resultfilename = uuidfile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadpath + "/" + resultfilename));

            return resultfilename;
        }

        return null;
    }
}
