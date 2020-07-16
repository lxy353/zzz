import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;


/**
 * 熟悉SAX解析流程
 * @author jakel
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//1.获取解析工厂
		SAXParser parser = factory.newSAXParser();
		//2。从解析工程获取解析器
		//3.加载文档Document 注册处理器
		//4.编写处理器
		PersonHandler handler = new PersonHandler();
		//5 解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("p.xml"),handler);
		
		
	}

}
class PersonHandler extends DefaultHandler2{
		@Override
	public void startDocument() throws SAXException {
		System.out.println("解析文档开始");
		super.startDocument();
	}
		@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+"---解析开始");
		super.startElement(uri, localName, qName, attributes);
	}
		@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+"---解析结束");
		super.endElement(uri, localName, qName);
	}
		@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String string = new String(ch,start,length).trim();
		if (string.length()>0) {
			System.out.println("内容为："+string);	
		}else {
			System.out.println("内容为: null");
		}
		
		super.characters(ch, start, length);
	}
		@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
		super.endDocument();
	}
	
}
