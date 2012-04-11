/**
 * Copyright 2012 BlueOxygen Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.meruvian.yama.rest.handler;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.rest.handler.ContentTypeHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.SerializationConfig.Feature;

/**
 * @author Dian Aditya
 * 
 */
public class JacksonJsonHandler implements ContentTypeHandler {

	private static final Log LOG = LogFactory.getLog(JacksonJsonHandler.class);

	protected ObjectMapper mapper;

	public JacksonJsonHandler() {
		LOG.info("Initializing json object mapper");
		mapper = new ObjectMapper();
	}

	private static final String DEFAULT_CONTENT_TYPE = "application/json";
	private String defaultEncoding = "ISO-8859-1";

	public void toObject(Reader in, Object target) throws IOException {
		LOG.debug("Deserializing " + target.getClass());

		mapper.configure(Feature.WRITE_NULL_MAP_VALUES, false);
		ObjectReader or = mapper.readerForUpdating(target);
		or.readValue(in);
	}

	public String fromObject(Object obj, String resultCode, Writer stream)
			throws IOException {
		LOG.debug("Serializing " + obj.getClass());

		mapper.configure(Feature.WRITE_NULL_MAP_VALUES, false);
		mapper.writeValue(stream, obj);
		return null;
	}

	public String getContentType() {
		return DEFAULT_CONTENT_TYPE + ";charset=" + this.defaultEncoding;
	}

	public String getExtension() {
		return "json";
	}
}
