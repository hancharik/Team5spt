/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester;

import java.io.*;
import java.util.Properties;
import java.util.Base64;
import java.util.Base64.Encoder;
/**
 *
 * @author marcc_000
 */
public final class Utility {
    private Utility()
    {
        
    }

    public static void writeFile(String filePath, String fileContents) {
        // add try catch logic...
        try {
            FileOutputStream FOS = new FileOutputStream(filePath);
            OutputStreamWriter OSW = new OutputStreamWriter(FOS, "utf-8");
            BufferedWriter bw = new BufferedWriter(OSW);
            bw.write(fileContents.replace("\n","\r\n"));
            bw.close();

        } catch (Exception e) {
            // do something here with the exception
        }
    }

    public static String getContentsOfFile(String filePath)
    {
        StringBuilder outString = new StringBuilder();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = buff.readLine()) != null) {
                outString.append(str +"\n");
            }
        } catch (IOException e) {
        } finally {
        try { buff.close(); } catch (Exception ex) { }
        }        
        return outString.toString();
    }
   
    public static String getConfigFile() {
        String AbsolutePath = new File(".").getAbsolutePath();
        return AbsolutePath + "config.txt";  // changed from config.properties, I can never find the file when I'm working on the program
    }

    public static void setConfigItem(String Item, String value) {
    // save a configuration item
        File configFile = new File(getConfigFile());
        try {
            Properties props = new Properties();
            props.setProperty(Item, value);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "host settings");
            writer.close();
        } catch (FileNotFoundException ex) {
        // file does not exist
        } catch (IOException ex) {
        // I/O error
        }
    }

    // get a configuration item by it's name
    public static String getConfigItem(String item, String defaultValue) {
        String val = null;
        try {
            FileReader reader = new FileReader(getConfigFile());
            Properties props = new Properties();
            props.load(reader);

            val = props.getProperty(item);

            reader.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        if (isNullOrWhiteSpace(val)) {
            val = defaultValue;
        }
        return val;
    }

    public static boolean isNullOrWhiteSpace(String a) {
        if (a!= null)
        {
            String b = a.replace("\r","");
            return b == null || (b.length() > 0 && b.trim().length() <= 0);
        }
        else
        {
            return true;
        }
    }
    
    public static String encryptString(String strSource) throws UnsupportedEncodingException
    {
        String retStr;
        // reverse the string
        strSource = reverseString(strSource);
        // convert to an array of bytes
        byte[] bArr =  strSource.getBytes();
        Base64.Encoder enc = Base64.getEncoder();
        
        bArr = enc.encode(bArr);
        retStr = new String(bArr);
        
        return retStr;
    }
    
    public static String decryptString(String strSource)
    {
        // do all the things in encrypt just in reverse
        //String strReturn = Base64.base64Decode(strSource);
        Base64.Decoder dec = Base64.getDecoder();
        
       byte[] decodedBytes = dec.decode(strSource.getBytes());
        
       String strReturn = new String(decodedBytes);
        
        //bArr = enc.encode(bArr);
        strReturn = reverseString(strReturn);
        return strReturn;
    }
    
    public static boolean AuthenticateUser(String UserID, String Password)
    {
        //Boolean bRet;
        String strOriginalPassword = getConfigItem(UserID, "");
        if (Utility.isNullOrWhiteSpace(strOriginalPassword))
        {
            // no password -- not in configfile, doesn't belong here
            return false;
        }
        // decrypt the password
        //strOriginalPassword = Utility.decryptString(Password);
        String encPassword="";
        try
        {
         encPassword = Utility.encryptString(Password);
        }
        catch (UnsupportedEncodingException uee)
        {
            
        }
        
        return strOriginalPassword.equals(encPassword);       // is our password the same?
        
        //return bRet;
    }
    
    
    public static String reverseString(String source)
    {
    int i;
    int len = source.length();
    StringBuilder sb = new StringBuilder(len);

    for (i = (len - 1); i >= 0; i--){
        sb.append(source.charAt(i));
    }

    return sb.toString();
    }
    
    
}
