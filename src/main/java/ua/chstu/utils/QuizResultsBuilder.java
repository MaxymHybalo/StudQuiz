package ua.chstu.utils;

import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.QuizResults;

import java.time.LocalDate;
import java.util.*;

public class QuizResultsBuilder {

    private Set<Question> questions;
    private Map<Integer, List<Boolean>> results;

    public QuizResultsBuilder(Set<Question> questions, Map<Integer, List<Boolean>> results) {
        this.questions = questions;
        this.results = results;
    }

    public QuizResults build(){
        return searchResults();
    }

    /*
     Carry out this logic to other object
    */
    private QuizResults searchResults(){
        QuizResults result = new QuizResults();
        result.setData(LocalDate.now());
        if(questions.size() == results.size()){
            int questionSize = questions.size();
            int rightResultCounter = 0;
            Question [] questionsArray = questions.toArray(new Question[questionSize]);
            for(int i=0;i<questionSize;i++){
                if(compareQuestionsMap(questionsArray[i].getOptions(), results.get(i))){
                    rightResultCounter++;
                }
            }
            result.setMark(calculateMark(questionSize,rightResultCounter));
        }
        return result;
    }

    private boolean compareQuestionsMap(Map<String, Boolean> expectedMap, List<Boolean> existResult){
        List<Boolean> expectedValues = new ArrayList<>();
        expectedValues.addAll(expectedMap.values());
        if(expectedValues.size() == existResult.size()){
            for (int i=0;i<expectedValues.size();i++){
                if(expectedValues.get(i) != existResult.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    private Short calculateMark(int maxQuestions, int rightQuestions){
        int calculatedValue = rightQuestions*100/maxQuestions;
        return new Short((short) calculatedValue);
    }
}
