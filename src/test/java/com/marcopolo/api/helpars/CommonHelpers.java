package com.marcopolo.api.helpars;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonHelpers {

    public String readConfig(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try(InputStream inputStream = loader.getResourceAsStream("application.properties")){
            properties.load(inputStream);

            String url;
            url= properties.get("base_url").toString()+ properties.get("version").toString();
            return url;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
