package com.arj.fileupload.dao;

import com.arj.fileupload.entity.UploadFile;
import java.util.List;

public interface UploadFileDAO {
    void save(UploadFile uploadFile);
    List<UploadFile> getAll();
    UploadFile getById(int id);
    void deleteById(int id);
}
