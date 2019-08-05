package com.poc.shared;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectUtil {


    public static String serializeObjectToString(Object object) throws IOException {
        		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        		String json = ow.writeValueAsString(object);
    return json;    		
    
    }

}