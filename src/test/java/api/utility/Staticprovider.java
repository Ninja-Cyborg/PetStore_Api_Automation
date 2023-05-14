package api.utility;


import org.testng.annotations.DataProvider;

public class Staticprovider {
    ExcelSheet excelSheet = new ExcelSheet();

    @DataProvider(name="usersData")
    public Object[][] getAllUsersData(){
        String sheetName ="data";

        int rows = excelSheet.getRowCount(sheetName);
        int columns = excelSheet.getColumnCount(sheetName);
        rows = rows-1;

        Object [][] data = new String[rows][columns];
        for(int i =0; i< rows; i++) {
            for(int j = 0; j<columns; j++) {
                data[i][j] = excelSheet.getCellData(sheetName, j, rows+2);
            }
        }
        return data;
    }

    @DataProvider(name="usernames")
    public String[] getUsernames(){
        String sheetName = "data";

        int rows = excelSheet.getRowCount(sheetName);
        rows = rows-1;

        String [] usernames = new String[rows];
        for(int i =0; i< rows; i++) {
            // usernames are in 2nd column of excelSheet
                usernames[i] = excelSheet.getCellData(sheetName, 2, i+1);
        }
        return usernames;
    }

    // getting order Details
    @DataProvider(name="orders")
    public Object[][] getOrders(){
        String sheetName = "orders";

        int rows = excelSheet.getRowCount(sheetName);
        int columns = excelSheet.getColumnCount(sheetName);
        rows = rows-1;

        Object [][] data = new String[rows][columns];
        for(int i =0; i< rows; i++) {
            for(int j = 0; j<columns; j++) {
                data[i][j] = excelSheet.getCellData(sheetName, j, rows+2);
            }
        }
        return data;
    }

    @DataProvider(name="pets")
    public Object[][] getPets(){
        String sheetName = "pets";

        int rows = excelSheet.getRowCount(sheetName);
        int columns = excelSheet.getColumnCount(sheetName);
        rows = rows-1;

        Object [][] data = new String[rows][columns];
        for(int i =0; i< rows; i++) {
            for(int j = 0; j<columns; j++) {
                data[i][j] = excelSheet.getCellData(sheetName, j, rows+2);
            }
        }
        return data;
    }
}
