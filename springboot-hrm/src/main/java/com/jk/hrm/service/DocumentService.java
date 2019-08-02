package com.jk.hrm.service;

import com.jk.hrm.bean.Document;

import java.util.List;

public interface DocumentService {

    void saveDocument(Document document);

    List<Document> findAllDocument();

    void deleteDocument(int id);

    void upDateDocument(Document document);

    Document getDocumentById(int id);


    List<Document> selectDocument(Document title);
}
