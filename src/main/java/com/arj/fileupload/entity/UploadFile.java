package com.arj.fileupload.entity;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_files")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "File.findAll", query = "SELECT f FROM File f"),
//    @NamedQuery(name = "File.findByFileId", query = "SELECT f FROM File f WHERE f.fileId = :fileId"),
//    @NamedQuery(name = "File.findByFileName", query = "SELECT f FROM File f WHERE f.fileName = :fileName")})
public class UploadFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_id")
    private Integer fileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "file_data")
    private Blob fileData;

    public UploadFile() {
    }

    public UploadFile(Integer fileId) {
        this.fileId = fileId;
    }

    public UploadFile(Integer fileId, String fileName, Blob fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileData = fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Blob getFileData() {
        return fileData;
    }

    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadFile)) {
            return false;
        }
        UploadFile other = (UploadFile) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arj.fileupload.entity.File[ fileId=" + fileId + " ]";
    }
    
}
