package com.lxy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.sun.tools.javac.util.Context;


/**
 * 熟悉SAX解析流程
 * @author jakel
 *
 */
public class XmlTest3  {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//1.获取解析工厂
		SAXParser parser = factory.newSAXParser();
		//2。从解析工程获取解析器
		//3.加载文档Document 注册处理器
		//4.编写处理器
		WebHandler handler = new WebHandler();
		//5 解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
		// get data
		WebConexte conexte = new WebConexte(handler.getEntities(),handler.getMappings());
		//假设你输入login
		String name = conexte.getClz("/login");
		Class clz=Class.forName(name);
		Servlet servlet = (Servlet)clz.getConstructors().newInsance();
		System.out.println(servlet);
		servlet.service();
	}

}
class WebHandler extends DefaultHandler2{
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tahString; //save
	private boolean isMapping = false;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"---解析开始");
		if (null!=qName) {
			tahString=qName;
			if (tahString.equals("servlet")) {
				entity = new Entity();
				isMapping =false;
			}else if (tahString.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping =true;
			}
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		String string = new String(ch,start,length).trim();
		if (null!=tahString) {//deal with null
		if (isMapping) {
		}else {
			if (tahString.equals("servlet-name")) {
				entity.setName(string);
			}else if (tahString.equals("servlet-class")) {
				if (string.length()>0) {
					entity.setClz(string);	
				}
			}
		
		}
	}
	}
		@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"---解析结束");
		if (null!=qName) {
		if (qName.equals("servlet")) {
			entities.add(entity);
		}else if (qName.equals("servlet-mapping")) {
			mappings.add(mapping);
		}
		}
	}
		public List<Entity> getEntities() {
			return entities;
		}
		public void setEntities(List<Entity> entities) {
			this.entities = entities;
		}
		public List<Mapping> getMappings() {
			return mappings;
		}
		public void setMappings(List<Mapping> mappings) {
			this.mappings = mappings;
		}	
	

	
	
}
