package com.arj.fileupload.dao.impl;

import com.arj.fileupload.dao.UploadFileDAO;
import com.arj.fileupload.entity.UploadFile;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "uploadFileDAO")
public class UploadFileDAOImpl implements UploadFileDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public UploadFileDAOImpl() {
        
    }

    public UploadFileDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    @Transactional
    public void save(UploadFile uploadFile) {
        session = sessionFactory.openSession();
        session.save(uploadFile);
        session.close();
    }

    @Override
    public List<UploadFile> getAll() {
        List<UploadFile> files = null;
        session = sessionFactory.openSession();
        files = session.createQuery("from UploadFile").list();
        session.close();
        return files;
    }

    @Override
    public UploadFile getById(int id) {
        session = sessionFactory.openSession();
        UploadFile file = (UploadFile) session.get(UploadFile.class, id);
        session.close();
        return file;
    }

    @Override
    public void deleteById(int id) {
        session = sessionFactory.openSession();
        UploadFile file = (UploadFile) session.get(UploadFile.class, id);
        session.delete(file);
        session.close();
    }

}
