package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

public class JodReportsDemo {

	public static void main(String[] args) {
		try {
			createReport();
		} catch (IOException | DocumentTemplateException e) {
			e.printStackTrace();
		}

	}

	private static void createReport() throws IOException, DocumentTemplateException {
		
		DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
		File file = getFile();
		DocumentTemplate template = documentTemplateFactory.getTemplate(file);
		Map<String, String> data = new HashMap<>();
		data.put("adjective1", "fantastic");
		data.put("adjective2", "sad");
		data.put("adjective3", "lovely");
		data.put("name", "Peter");
		data.put("age", "33");
		data.put("money", "" + 1200.34);
		FileOutputStream fileOutputStream = new FileOutputStream(new File(new File("output"), "templates1-out.odt"));
		template.createDocument(data, fileOutputStream);
		
	}

	private static File getFile() throws FileNotFoundException {
		File templateFolder = new File("templates");
		if (! templateFolder.isDirectory()){
			throw new FileNotFoundException("Could not find templates folder");
		}
		File file = new File(templateFolder, "template1.odt");
		return file;
	}

}
