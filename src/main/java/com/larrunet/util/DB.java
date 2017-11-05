/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.larrunet.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.JOptionPane;

/**
 *
 * @author kael
 */
public class DB {

    private String dbName;
    private String dbUser;
    private String dbPass;

    public DB(String dbName, String dbUser, String dbPass) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void Backupdbtosql() {
        try {

            /*NOTE: Getting path to the Jar file being executed*/
 /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = DB.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();


            /*NOTE: Creating Path Constraints for folder saving*/
 /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "/backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            /*NOTE: Creating Path Constraints for backup saving*/
 /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = jarDir + "/backup/" + "backup.sql";

            System.out.println(savePath);
            
            /*NOTE: Used to create a cmd command*/
            //String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;
            String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass + " " + dbName + " -r " + savePath;
            
            System.out.println(executeCmd);
            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
    }
}
