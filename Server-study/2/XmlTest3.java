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
 * ��ϤSAX��������
 * @author jakel
 *
 */
public class XmlTest3  {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX����
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//1.��ȡ��������
		SAXParser parser = factory.newSAXParser();
		//2���ӽ������̻�ȡ������
		//3.�����ĵ�Document ע�ᴦ����
		//4.��д������
		WebHandler handler = new WebHandler();
		//5 ����
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
		// get data
		WebConexte conexte = new WebConexte(handler.getEntities(),handler.getMappings());
		//����������login
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
		System.out.println(qName+"---������ʼ");
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
		System.out.println(qName+"---��������");
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
