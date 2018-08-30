
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import weka.associations.Apriori;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MarkSixProcess {
    public static void main (String[] arg)throws IOException, InvalidFormatException {
        int totalNumberResult = 0;
        int max = 0;
        int min = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        String SAMPLE_XLSX_FILE_PATH = "./markSixResult.xlsx";
        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        //System.out.println(workbook.getNumberOfSheets());
        Sheet sheet = workbook.getSheetAt(0);
        totalNumberResult = sheet.getPhysicalNumberOfRows();
        sheet.forEach(row ->{
            List<Integer> iList = new ArrayList<>();
            row.forEach(cell->{
              //System.out.print(dataFormatter.formatCellValue(cell)+ " ");
              int iValue = Integer.parseInt(dataFormatter.formatCellValue(cell));
              iList.add(iValue);
            });
            totalList.add(iList);
            //System.out.println("");
                }

        );
        System.out.println("success");
        //Start analysis
        int[] countArray = new int[49];
        for (int i = 0; i < 49; i++) {
            countArray[i] = 0;
        }
        for (List<Integer> resultList : totalList) {
            for (int oneResult : resultList) {
                for (int i = 0; i < 49; i++) {
                    if ((i + 1) == oneResult) {
                        countArray[i]++;
                    }
                }
            }
        }
        //find max min
        for (int i = 0; i < 49; i++) {
            double r = (double) countArray[i] / totalNumberResult;
            System.out.println((i + 1) + " : " + countArray[i] + ", % = " + r);
            if (countArray[i] > countArray[max]) {
                max = i;
            }
            if (countArray[i] < countArray[min]) {
                min = i;
            }


        }
        System.out.println("Max : "+(max+1));
        System.out.println("Min : "+(min+1));

        //Sorting
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 49; i++){
            map.put(countArray[i], i);
        }
        Arrays.sort(countArray);
        for (int i = 0; i < 49; i++){
            System.out.println((map.get(countArray[i])+1)+" : "+countArray[i]);
        }
        //Association rule

    }
}
