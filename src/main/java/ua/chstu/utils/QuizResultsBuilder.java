package ua.chstu.utils;

import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.QuizResults;

import java.time.LocalDate;
import java.util.*;

public class QuizResultsBuilder {

    private static final String BAD_GRADE = "Погано";
    private static final String NOT_BAD_GRADE = "Непогано";
    private static final String NORMAL_GRADE = "Нормально";
    private static final String GOOD_GRADE = "Гарней результат";
    private static final String BEST_GRADE = "Відмінно";

    private Set<Question> questions;
    private Map<Integer, List<Boolean>> results;

    public QuizResultsBuilder(Set<Question> questions, Map<Integer, List<Boolean>> results) {
        this.questions = questions;
        this.results = results;
    }

    public QuizResults build() {
        QuizResults results = new QuizResults();
        results = searchResults();
        results = updateGradation(results);
        return results;
    }

    private QuizResults updateGradation(QuizResults quizResults) {
        short mark = quizResults.getMark();
        if(mark <= 10){
            quizResults.setGradation(BAD_GRADE);
        }else if (mark <= 30){
            quizResults.setGradation(NOT_BAD_GRADE);
        }else if(mark <= 60){
            quizResults.setGradation(NORMAL_GRADE);
        }else if(mark <= 80){
            quizResults.setGradation(GOOD_GRADE);
        }else {
            quizResults.setGradation(BEST_GRADE);
        }
        return quizResults;
    }

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
