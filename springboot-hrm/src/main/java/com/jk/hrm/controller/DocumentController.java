package com.jk.hrm.controller;

import com.jk.hrm.bean.Document;
import com.jk.hrm.bean.User;
import com.jk.hrm.constant.WebConstant;
import com.jk.hrm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;


    //去添加
    @RequestMapping("/document/toAddDocument")
    public String toAddDocument(){
        return "/document/addDocument";
    }

    @RequestMapping("/document/addDocument")
    public void adddocument(MultipartFile file,Document document, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String realPath = request.getServletContext().getRealPath("images/document");
        String newfilename = UUID.randomUUID().toString() + file.getOriginalFilename();
        file.transferTo(new File(realPath+newfilename));
        document.setUrl(realPath+newfilename);
        document.setCreateDate(new Date());
        //获取User
        User user = (User) request.getSession().getAttribute(WebConstant.SESSION_USER);
        document.setUser(user);
        documentService.saveDocument(document);
        response.sendRedirect("/document/documentList");
    }


    //查询
    @RequestMapping("/document/documentList")
    public String documentList(Model model){
        List<Document> documents = documentService.findAllDocument();
        model.addAttribute("documents",documents);
        return "/document/documentList";
    }


    //删除
    @RequestMapping("/document/deleteDocument")
    public void deleteDocument(HttpServletResponse response,int id) throws IOException {
        documentService.deleteDocument(id);
        response.sendRedirect("/document/documentList");
    }

    //修改

    @RequestMapping("/document/toUpdateDocument")
    public String toupdataDocument(String id,Model model) {
        Document document =  documentService.getDocumentById(Integer.parseInt(id));
        model.addAttribute("document",document);
        return "document/updateDocument";
    }
    @RequestMapping("/document/updateDocument")
    public void updataDocument(Document document,HttpServletResponse response) throws IOException {
        documentService.upDateDocument(document);
        response.sendRedirect("/document/documentList");
    }


    //下载/document/deleteDocument
    @RequestMapping("/document/downDocument")
    public void downDocument(String id ,HttpServletResponse response,HttpServletRequest request) throws IOException {
        Document document= documentService.getDocumentById(Integer.parseInt(id));
        String title = document.getTitle();
        String filename=document.getUrl();
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        //从服务器上取响应给浏览器的文件
        //把读取到的文件响应给浏览器
        //定义缓冲数组
        byte[] buff=  new byte[1024];
        //定义输入流，用来读取服务器上资源
        BufferedInputStream bis=null;
        //输出流把输入流中的数据写出去
        OutputStream os=null;
        os = response.getOutputStream();

        //把服务器上的文件读取到IO中
        bis = new BufferedInputStream(new FileInputStream(new File(filename)));
        int i = bis.read(buff);
        //循环读取服务器上的资源
        while (i!=-1){
            os.write(buff,0,buff.length);
            os.flush();
            i=bis.read(buff);
        }
        //关闭流
        bis.close();
        os.close();
    }
    //模糊查询
    @RequestMapping("/document/selectDocument")
    public String selectDocument(Model model,Document title){
        List<Document> documents = documentService.selectDocument(title);
        model.addAttribute("documents",documents);
        return "/document/documentList";
    }


}
