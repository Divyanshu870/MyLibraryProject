package com.asus.mylibrary.utils;

import java.io.File;

/**
 * @author Jaypatelbond created on 25-05-2020.
 * @version 1.0
 * @see Constant
 */

public class SearchDocument {
    //Checking the Directories for the required extensions.
    public static void load_Directory_Files(File directory) {
        File[] fileList = directory.listFiles();
        if(fileList != null && fileList.length > 0){
            for (int i=0; i<fileList.length; i++){
                if(fileList[i].isDirectory()){
                    load_Directory_Files(fileList[i]);
                }
                else {
                    String name = fileList[i].getName().toLowerCase();
                    for (String extension: Constant.documentExtensions){
                        //check the type of file
                        if(name.endsWith(extension)){
                            Constant.alldocumentList.add(fileList[i]);
                            //when we found file
                            break;
                        }
                    }
                }
            }
        }
    }
}
