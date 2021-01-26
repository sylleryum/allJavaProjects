import java.io.IOException;
import javax.swing.*;
import javax.swing.JOptionPane;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class JsoupMain {
	public static void main(String[] args) {
		
		try{
		Document doc = Jsoup.connect("http://www.jornaltoahora.com.br/?p=1197").get();
		doc = null;
		/*String titl = doc.select("span[ID=email-notes]").text();
		String title = doc.title();*/
		//System.out.println("Span ID: " + titl);
		System.out.println("ok");
		} catch (IOException e1){
			JOptionPane.showMessageDialog(null, "nop");
			//e1.printStackTrace();
		}

	}
}