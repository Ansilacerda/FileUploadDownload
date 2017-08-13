package com.arj.fileupload.controller;

import com.arj.fileupload.dao.UploadFileDAO;
import com.arj.fileupload.entity.UploadFile;
import java.io.OutputStream;
import java.sql.Blob;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private UploadFileDAO uploadFileDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(method = RequestMethod.GET)
    public String showUploadForm() {
        return "upload";
    }

    @RequestMapping(value = "doUpload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile fileUpload) throws Exception {
        if (fileUpload != null && fileUpload.getSize() > 0) {
//            for (MultipartFile aFile : fileUpload) {
//                System.out.println("Saving file: " + aFile.getOriginalFilename());
            Session session = sessionFactory.openSession();
            Blob blob = Hibernate.getLobCreator(session).createBlob(fileUpload.getBytes());
            UploadFile uploadFile = new UploadFile();
            uploadFile.setFileName(fileUpload.getOriginalFilename());
            uploadFile.setFileData(blob);
            uploadFileDAO.save(uploadFile);
            session.close();
//            }
        }
        return "redirect:/?success";
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String viewAll(Model model) {
        model.addAttribute("allfiles", uploadFileDAO.getAll());
        return "viewall";
    }

    @RequestMapping(value = "/view/{fileId}", method = RequestMethod.GET)
    public String viewFile(@PathVariable("fileId") int fileId, HttpServletResponse response) throws Exception {
        UploadFile file = uploadFileDAO.getById(fileId);
        response.setHeader("Content-Disposition", "inline;filename=\"" + file.getFileName() + "\"");
        OutputStream out = response.getOutputStream();
        IOUtils.copy(file.getFileData().getBinaryStream(), out);
        out.flush();
        out.close();
        return "redirect:/viewall";
    }
    
    @RequestMapping(value = "/download/{fileId}", method = RequestMethod.GET)
    @ResponseBody
    public String download(){
        return "<h1 align=\"center\">This page is under construction.</h1>";
    }

    @RequestMapping(value = "/delete/{fileId}", method = RequestMethod.GET)
    public String delete(@PathVariable("fileId") int fileId) {
        uploadFileDAO.deleteById(fileId);
        return "redirect:/viewall?deleted";
//        return uploadFileDAO.getById(fileId).getFileName();
    }

}
