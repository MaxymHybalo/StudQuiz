package ua.chstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.runners.JUnit44RunnerImpl;
import ua.chstu.data.domain.QuizResults;
import ua.chstu.utils.QuizResultsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuizResultsBuilderTest {
    String mock  =  "[{\"id\":\"59359049fa86291b98f1b587\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":75,\"gradation\":\"Гарней результат\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"59359506fa86291b98f1b58b\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":0,\"gradation\":\"Погано\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Англійська\",\"categoryName\":null,\"questionCase\":\"Language Portfolio\"}},{\"id\":\"59359016fa86291b98f1b586\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":50,\"gradation\":\"Нормально\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"593593f5fa86291b98f1b589\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":0,\"gradation\":\"Погано\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"593594fafa86291b98f1b58a\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":0,\"gradation\":\"Погано\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"5935733cfa86291b98f1b583\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":75,\"gradation\":\"Гарней результат\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"5935916dfa86291b98f1b588\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":0,\"gradation\":\"Погано\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}},{\"id\":\"593575a3fa86291b98f1b584\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":0,\"gradation\":\"Погано\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Англійська\",\"categoryName\":null,\"questionCase\":\"Language Portfolio\"}},{\"id\":\"59358f9afa86291b98f1b585\",\"userId\":\"5935724bfa86291b98f1b582\",\"mark\":50,\"gradation\":\"Нормально\",\"data\":{\"year\":2017,\"month\":\"JUNE\",\"dayOfMonth\":5,\"dayOfWeek\":\"MONDAY\",\"era\":\"CE\",\"dayOfYear\":156,\"leapYear\":false,\"monthValue\":6,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"params\":{\"category\":\"58d9532020b7fc0c15214f87\",\"name\":\"Математика\",\"categoryName\":null,\"questionCase\":\"Табличка множення\"}}]";

    private List<QuizResults> resource = new ArrayList<>();
    @Before
    public void init(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(mapper.readValue(mock, resource.getClass()).getClass());
            resource = mapper.readValue(mock, resource.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
