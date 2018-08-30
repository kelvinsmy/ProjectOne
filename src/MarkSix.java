import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MarkSix {
    public static void main(String[] args) throws IOException {
        int totalNumberResult = 0;
        int max = 0;
        int min = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        //for (int y = 1993; y <= 2018; y++) {
        for (int y = 1993; y <= 2018; y++) {
            for (int m = 1; m <= 12; m++) {
                //String url = "http://hk.myfreepost.com/en/hkjc/marksix/resultlist/?dMonth=06&dYear=2018";
                String url = "http://hk.myfreepost.com/en/hkjc/marksix/resultlist/?dMonth=" + m + "&dYear=" + y;
                Document document = Jsoup.connect(url).get();
                if (document != null) {
                    Element body = document.body();
                    Elements paragraphs = body.getElementsByTag("td");
                    int i = 0;
                    int j = 0;
                    for (Element paragraph : paragraphs) {
                        if (i > 1) {
                            if (j % 2 == 0) {
                                System.out.print(paragraph.text());
                                j++;
                            } else {
                                //System.out.println(paragraph.text());
                                String s = paragraph.text();
                                s = s.replaceAll("\\D+", ",");
                                List<String> list = Arrays.asList(s.split(","));
                                List<Integer> iList = list.stream()
                                        .map(a -> Integer.parseInt(a))
                                        .collect(Collectors.toList());
                                totalList.add(iList);
                                totalNumberResult++;
                                System.out.println(iList);
                                j++;
                            }
                        }
                        i++;
                    }
                }
            }
        }
        //end of extraction
        //export to excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Mark Six Result");
        int countRow = 0;
        for (List<Integer> r :totalList) {
            XSSFRow row = spreadsheet.createRow((short) countRow);
            countRow++;
            for (int i =0; i<r.size();i++){
                row.createCell(i).setCellValue(r.get(i));
            }
        }
        FileOutputStream out = new FileOutputStream(new File("markSixResult.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("markSixResult.xlsx written successfully");
        //end of export to excel

    }
}
