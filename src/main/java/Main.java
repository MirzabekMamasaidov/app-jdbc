import entity.Category;
import entity.Currency;
import entity.Response;
import repository.CategoryRepository;
import repository.CurrencyRepository;
import utils.DbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
      /*  System.out.println("Id ni kiriting");
        int id = scanner.nextInt();
        System.out.println("Category name ni kiriting");
        String name = scannerStr.nextLine();
        CategoryRepository.addCategory(id,name);
        System.out.println(CategoryRepository.getCategories());*/

    /*    System.out.println("nomi ni kiriitng:");
        String name= scanner.nextLine();
        scanner=new Scanner(System.in);
        System.out.println("type ni kiriting:");
        String type=scanner.nextLine();
        System.out.println("Yangi nomni   kiriting:");
        String n_name=scanner.nextLine();
        Response response=CategoryRepository.callFunction(name,type,n_name);
        System.out.println("it is ok");
        System.out.println(response);

        System.out.println(CategoryRepository.getCategories());*/

        System.out.println("nomi ni kiriitng:");
        String name= scanner.nextLine();

        Response response1 = CurrencyRepository.callFuncAddCurr(name);
        System.out.println(response1);

        for (Currency currency : CurrencyRepository.getCurrencies()) {
            System.out.println(currency);
        }
    }
}
