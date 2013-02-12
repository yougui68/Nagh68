/**
 * 
 */
package com.blog.samples.web.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @author yosri-amira
 *
 */
public class DateSerializer extends JsonSerializer<Date>{

	/**
	 * 
	 */
	public DateSerializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Date date_value, JsonGenerator Jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String dateformat =format.format(date_value);
		Jgen.writeString(dateformat);
		
		
	}

}
