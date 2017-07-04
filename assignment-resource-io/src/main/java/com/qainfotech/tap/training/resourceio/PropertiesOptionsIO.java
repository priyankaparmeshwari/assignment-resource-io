package com.qainfotech.tap.training.resourceio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class PropertiesOptionsIO{
    
    public Object getOptionValue(String optionKey) throws IOException {
    	Properties prop = new Properties();
    	InputStream input = null;
    	input = new FileInputStream("C:\\Users\\priyankaparmeshwari\\Desktop\\io 1\\assignment-resource-io\\src\\main\\resources\\options.properties");
    	prop.load(input);
    	String x=prop.getProperty(optionKey);
    	return x;
 }
    public void addOption(String optionKey, Object optionValue) throws IOException {
    	Properties prop = new Properties();
    	FileOutputStream o = null;
    	o = new FileOutputStream("C:\\Users\\priyankaparmeshwari\\Desktop\\io 1\\assignment-resource-io\\src\\main\\resources\\options.properties",true);
    prop.setProperty(optionKey,optionValue.toString());
   prop.store(o,optionValue.toString());
    o.close();
    }  
}
