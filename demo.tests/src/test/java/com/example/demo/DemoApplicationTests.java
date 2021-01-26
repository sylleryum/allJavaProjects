package com.example.demo;

import com.example.demo.pojo.Aluno;
import com.example.demo.pojo.Ticket;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
@SpringBootTest
class DemoApplicationTests {

    private static final String FILE_NAME = "C:/temp/Aluno.xls";
    private static final String SAVE_FILE = "C:/temp/novo.xls";
    //private static final String HR_FILE = "C:/temp/novo.xls";
    private static final String HR_FILE = "C:/temp/HR volume last 6 months.xls";
    private static final int TNUMBER = 3;
    private static final int EE_NUMBER = 15;

    @Test
    void contextLoads() throws Exception {


        FileInputStream arquivo = new FileInputStream(new File(FILE_NAME));
        HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
        HSSFSheet sheetAlunos = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheetAlunos.iterator();
        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            Aluno aluno = new Aluno();
            listaAlunos.add(aluno);
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println();
                switch (cell.getColumnIndex()) {
                    case 0:
                        aluno.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        aluno.setRa(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case 2:
                        aluno.setNota1(cell.getNumericCellValue());
                        break;
                    case 3:
                        aluno.setNota2(cell.getNumericCellValue());
                        break;
                    case 4:
                        aluno.setMedia(cell.getNumericCellValue());
                        break;
                    case 5:
                        aluno.setAprovado(cell.getBooleanCellValue());
                        break;
                }
            }
        }
        System.out.println("test");
        arquivo.close();

        //==========================================================================

        Workbook wb = new HSSFWorkbook();
//Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
// Create a row and put some cells in it. Rows are 0 based.
        //index of row
        Row row = sheet.createRow(0);
// Create a cell and put a date value in it.  The first cell is not styled
// as a date.
        //index of column
        Cell cell = row.createCell(0);
        cell.setCellValue(listaAlunos.get(0).getNome());
        cell = row.createCell(1);
        cell.setCellValue(listaAlunos.get(0).getMedia());
        cell = row.createCell(2);
        cell.setCellValue(listaAlunos.get(0).getNota1());
        cell = row.createCell(3);
        cell.setCellValue(listaAlunos.get(0).getNota2());


// Write the output to a file
        try (OutputStream fileOut = new FileOutputStream(SAVE_FILE)) {
            wb.write(fileOut);
        }

//        HSSFWorkbook workbookWrite = new HSSFWorkbook();
//        HSSFSheet sheetAlunosWrite = workbook.createSheet("Alunos");
//
//        listaAlunos.add(new Aluno("Eduardo", "9876525", 7, 8, 0, false));
//        listaAlunos.add(new Aluno("Luiz", "1234466", 5, 8, 0, false));
//        listaAlunos.add(new Aluno("Bruna", "6545657", 7, 6, 0, false));
//        listaAlunos.add(new Aluno("Carlos", "3456558", 10, 3, 0, false));
//        listaAlunos.add(new Aluno("Sonia", "6544546", 7, 8, 0, false));
//        listaAlunos.add(new Aluno("Brianda", "3234535", 6, 5, 0, false));
//        listaAlunos.add(new Aluno("Pedro", "4234524", 7, 5, 0, false));
//        listaAlunos.add(new Aluno("Julio", "5434513", 7, 2, 0, false));
//        listaAlunos.add(new Aluno("Henrique", "6543452", 7, 8, 0, false));
//        listaAlunos.add(new Aluno("Fernando", "4345651", 5, 8, 0, false));
//        listaAlunos.add(new Aluno("Vitor", "4332341", 7, 9, 0, false));
//
//        int rownum = 0;
//        for (Aluno aluno : listaAlunos) {
//            Row row = sheetAlunosWrite.createRow(rownum++);
//            int cellnum = 0;
//            Cell cellNome = row.createCell(cellnum++);
//            cellNome.setCellValue(aluno.getNome());
//            Cell cellRa = row.createCell(cellnum++);
//            cellRa.setCellValue(aluno.getRa());
//            Cell cellNota1 = row.createCell(cellnum++);
//            cellNota1.setCellValue(aluno.getNota1());
//            Cell cellNota2 = row.createCell(cellnum++);
//            cellNota2.setCellValue(aluno.getNota2());
//            Cell cellMedia = row.createCell(cellnum++);
//            cellMedia.setCellValue((aluno.getNota1() + aluno.getNota2()) / 2);
//            Cell cellAprovado = row.createCell(cellnum++);
//            cellAprovado.setCellValue(cellMedia.getNumericCellValue() >= 6);
//            System.out.println("po");
//        }
//
//        try {
//            FileOutputStream out =
//                    new FileOutputStream(new File(SAVE_FILE));
//            workbookWrite.write(out);
//            out.close();
//            System.out.println("Arquivo Excel criado com sucesso!");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Arquivo não encontrado!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Erro na edição do arquivo!");
//        }
//
//
//        System.out.println("test");

    }

    @Test
    void test() throws Exception {

        //get tickets
        FileInputStream arquivo = new FileInputStream(new File(HR_FILE));
        HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
        HSSFSheet sheetTickets = workbook.getSheetAt(0);

        HSSFSheet sheetTnumber = workbook.getSheet("Brazil");
        Iterator<Row> rowIteratorTnumber = sheetTnumber.iterator();

        Iterator<Row> rowIterator = sheetTickets.iterator();
        List<Ticket> listaAlunos = new ArrayList<>();

        List<String> listTnumber = new ArrayList<>();
        List<String> match = new ArrayList<>();

        //gettnumber
        while (rowIteratorTnumber.hasNext()) {
            Row row = rowIteratorTnumber.next();
            //Iterator<Cell> cellIterator = row.cellIterator();

            Ticket ticket = new Ticket();
            listaAlunos.add(ticket);

            listTnumber.add(String.valueOf(row.getCell(TNUMBER)));
        }
        ////////////
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();

            for (String str: listTnumber){
                if (String.valueOf(row.getCell(EE_NUMBER)).equalsIgnoreCase(str)){
                    match.add(str);
                }
            }

        }


        System.out.println("test");
        arquivo.close();

   }

    @Test
    void test1(){
        /*
        Escrever um algoritmo para calcular média de idade dos dois filhos de dona Maria 

    Inteiro idade1, idade2
    Real mediaIdade
    Escreva: "digite primeira idade"
    Leia: idade1
    Escreva: "digite segunda idade"
    Leia: idade2
    mediaIdade: (idade1+idade2)/2
    Escreva: "a idade média dos filhos é: " + mediaIdade
         */

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int idade1, idade2;
        long mediaIdade;
        System.out.println("Digite primeira idade: ");
        idade1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite segunda idade: ");
        idade2 = Integer.parseInt(scanner.nextLine());
        mediaIdade = (idade1+idade2)/2;
        System.out.println("a idade média dos filhos é: "+mediaIdade);





    }

}
