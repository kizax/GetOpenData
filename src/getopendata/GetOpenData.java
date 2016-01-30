package getopendata;

import javax.xml.parsers.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetOpenData {

    public static void main(String[] args) throws ParserConfigurationException {

        try {
            String url = "http://data.taipei/tisv/VDDATA";
            HttpResponse response = HttpUtil.httpGet(url);

            InputStream inputStream = response.getEntity().getContent();
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);

            StringBuilder inputStringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"));

            String xmlStr = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                xmlStr += (line + '\n');
            }

            System.out.println(inputStringBuilder.toString());

            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new StringBufferInputStream(xmlStr));

            String exchangeTime = doc.getElementsByTagName("ExchangeTime").item(0)
                    .getTextContent();

            System.out.println(exchangeTime);


            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss"); //2016/01/30T12:12:21

            Date date = (Date) format.parse(exchangeTime);
            
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2016-01-15 00:00:00
            String reportDate = format2.format(date);

            System.out.println(reportDate);

            NodeList list = doc.getElementsByTagName("VDDevice");

            int a = list.getLength();

            System.out.println(a);

            for (int nodeCount = 0; nodeCount < list.getLength(); nodeCount++) {

                Node nNode = list.item(nodeCount);

                // need to handle many lane data
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("DeviceID: " + eElement.getElementsByTagName("DeviceID")
                            .item(0)
                            .getTextContent());
                    System.out.println("TimeInterval: " + eElement.getElementsByTagName("TimeInterval")
                            .item(0)
                            .getTextContent());
                    System.out.println("TotalOfLane: " + eElement.getElementsByTagName("TotalOfLane")
                            .item(0)
                            .getTextContent());

                    int laneNum = Integer.parseInt(eElement.getElementsByTagName("TotalOfLane").item(0)
                            .getTextContent());

                    for (int i = 0; i < laneNum; i++) {
                        System.out.println("LaneNO" + eElement.getElementsByTagName("LaneNO")
                                .item(i)
                                .getTextContent());
                        System.out.println("Volume: " + eElement.getElementsByTagName("Volume")
                                .item(i)
                                .getTextContent());
                        System.out.println("AvgSpeed: " + eElement.getElementsByTagName("AvgSpeed")
                                .item(i)
                                .getTextContent());
                        System.out.println("AvgOccupancy: " + eElement.getElementsByTagName("AvgOccupancy")
                                .item(i)
                                .getTextContent());
                        System.out.println("Svolume: " + eElement.getElementsByTagName("Svolume")
                                .item(i)
                                .getTextContent());
                        System.out.println("Mvolume: " + eElement.getElementsByTagName("Mvolume")
                                .item(i)
                                .getTextContent());
                        System.out.println("Lvolume: " + eElement.getElementsByTagName("Lvolume")
                                .item(i)
                                .getTextContent());
                    }

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(GetOpenData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GetOpenData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GetOpenData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
