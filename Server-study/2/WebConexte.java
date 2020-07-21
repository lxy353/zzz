package com.lxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebConexte {
	private List<Entity> entities = null;
	private List<Mapping> mappings = null;
	
	//key -servlet   value-- class
	private Map<String, String> entityMap= new HashMap<String, String>();
	//key--url parrtern  value---servlet-name
	private Map<String, String> mappingMap= new HashMap<String, String>();
	public WebConexte(List<Entity> entities, List<Mapping> mappings) {
		super();
		this.entities = entities;
		this.mappings = mappings;
		for (Entity entity:entities) {
			entityMap.put(entity.getName(), entity.getClz());//entitylisy --- map
		}
		for (Mapping mapping:mappings) {
			for (String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());//mapping --- map
			}
			
		}
	}
	/** 通过URL的路径找到了对应的class
	 * 
	 * 
	 */
	public String getClz(String pattern) {
		String nameString= mappingMap.get(pattern);
		return entityMap.get(nameString);
		
	}

}
