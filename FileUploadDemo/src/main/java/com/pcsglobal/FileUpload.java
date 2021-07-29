package com.pcsglobal;

import java.io.IOException;
import java.io.File;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
//@WebServlet("/FileUpload")  // We are using the web.xml servlet and servlet mapping xml tags to map this servlet
@SuppressWarnings("serial")
public class FileUpload extends HttpServlet 
{

//	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Servlet utility to handle a List of files to store in a temporary location using DiskFileItemFactory
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory()); 
		
		try 
		{
			// Processes the request from html encoding type multipart/form-data stream
			// returns A map of FileItem instances parsed from the request
			List<FileItem> multifiles = sf.parseRequest(request);
			
			for(FileItem item: multifiles)
			{
				try 
				{
					// writes/uploads each of the multi files by creating a new File instance by converting the given
					// pathname string into an abstract pathname
					item.write(new File("D:/Debasis/eclipse-workspace/FileUploadDemo/" + item.getName()));
					// item.write(new File("/Debasis/" + item.getName()));
					System.out.println("File being uploaded..."+item.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("File uploaded...");
		} 
		catch (FileUploadException e) 
		{
			e.printStackTrace();
		}
	}
}
