/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hck.imiao.udp;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ErrorLog
{
    public static final String errorLogFileName = "testpush.txt";
    public static void Log(String filePath, String content) 
    {   
        try
        {
           File f = new File(filePath);  
           if (!f.exists()) 
            { 
                f.createNewFile();// 不存在则创建   
            }  
           FileOutputStream oFileOutputStream = new FileOutputStream(f,true); 
           StringBuilder oStringBuilder = new StringBuilder();          
           //content += System.getProperty("line.separator");
           oStringBuilder.append(getCurrentDateStr());
           oStringBuilder.append("  ");
           oStringBuilder.append(content);
           oStringBuilder.append(System.getProperty("line.separator"));
           oFileOutputStream.write(content.getBytes());
           oFileOutputStream.close();
        }
        catch(Exception e) 
         {
            Log(e.getMessage());
         }
    }   
    public static void Log(String content) 
    {   
        //String filePath = System.getProperty("user.dir") + java.io.File.separator + BaseClass.ConfigInfor.appName + java.io.File.separator + "errorlog";
        String filePath = getErrorlogPath();
        //java.io.File.
        try
        {
           File dir = new File(filePath);  
           if (!dir.exists()) 
            { 
                dir.mkdir();
                //f.createNewFile();// 不存在则创建   
            } 
           File f = new File(filePath + java.io.File.separator + errorLogFileName); 
           if (!f.exists()) 
            { 
               f.createNewFile();// 不存在则创建   
            }  
           FileOutputStream oFileOutputStream = new FileOutputStream(f,true);            
           StringBuilder oStringBuilder = new StringBuilder();           
           oStringBuilder.append(getCurrentDateStr());
           oStringBuilder.append("  ");
           oStringBuilder.append(content);
           oStringBuilder.append(System.getProperty("line.separator"));
           oFileOutputStream.write(oStringBuilder.toString().getBytes());
           oFileOutputStream.close();
        }
        catch(Exception e) 
         {
            e.printStackTrace();
         }
    } 
    public static void DeleteFile(String filePath) 
    {   
        try
        {
           File f = new File(filePath);  
           if (f.exists()) 
            { 
                f.delete();
            }  
        }
        catch(Exception e) 
         {
            Log(e.getMessage());
         }
    } 
     public static void Exist(String Path)
     {
          File dir = new File(Path);  
           if (!dir.exists()) 
            { 
                dir.mkdirs();
            } 
     }
    public static String getErrorlogPath()
    {
        String filePath = System.getProperty("user.dir") + java.io.File.separator +"errorlog";
        return filePath;
    }
    public static String getCurrentDateStr()
    {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }      
}
