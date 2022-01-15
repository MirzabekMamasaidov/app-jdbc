package repository;

import entity.Currency;
import entity.Response;
import lombok.SneakyThrows;
import lombok.ToString;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {

    @SneakyThrows
    public static List<Currency> getCurrencies(){
        Connection connection = DbConfig.ulanish();
        List<Currency> currencyList = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from currency");

        while (resultSet.next()) {
            Currency currency = new Currency();

            currency.setId(resultSet.getInt(1));
            currency.setName(resultSet.getString(2));
            currency.setActive(resultSet.getBoolean(3));

            currencyList.add(currency);
        }
        return currencyList;
    }
    @SneakyThrows
    public static Response callFuncAddCurr(String name){
        Response response = new Response();
        Connection connection=DbConfig.ulanish();

        CallableStatement callableStatement = connection.prepareCall("{call add_currency(?,?,?)}");

        callableStatement.setString(1,name);
        callableStatement.registerOutParameter(2, Types.BOOLEAN);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        boolean execute = callableStatement.execute();
        response.setSuccess(callableStatement.getBoolean(2));
        response.setMessage(callableStatement.getString(3));

        System.out.println(response);
        return response;
    }
}
