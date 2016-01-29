package getopendata;

import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author hunter
 */
public class GetOpenData {

    public static void main(String[] args) throws ParserConfigurationException {

        try {
            String url = "http://data.taipei/tisv/VDDATA";
            HttpResponse response = HttpUtil.httpGet(url);

            InputStream inputStream = response.getEntity().getContent();
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);

            StringBuilder inputStringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"));
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
            }
            System.out.println(inputStringBuilder.toString());

//            URL url = new URL(urlString);
//
//            URLConnection conn = url.openConnection();
//
//            DocumentBuilderFactory factory
//                    = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//
//            Document doc = builder.parse(conn.getInputStream());
//
//            Element root = doc.getDocumentElement();

        } catch (IOException ex) {
            Logger.getLogger(GetOpenData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
