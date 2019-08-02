package com.jk.hrm.service.impl;

import com.jk.hrm.bean.Document;
import com.jk.hrm.dao.DocumentMapper;
import com.jk.hrm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentMapper documentMapper;
    @Override
    public void saveDocument(Document document) {
        documentMapper.save(document);
    }

    @Override
    public List<Document> findAllDocument() {
        return documentMapper.findByPage(null);
    }

    @Override
    public void deleteDocument(int id) {
        documentMapper.delete(id);
    }

    @Override
    public void upDateDocument(Document document) {
        documentMapper.update(document);
    }

    @Override
    public Document getDocumentById(int id) {
        return documentMapper.get(id);
    }

    @Override
    public List<Document> selectDocument(Document title) {
        return documentMapper.selectDocument(title);
    }


}
