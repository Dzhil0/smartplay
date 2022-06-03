package com.example.smartplay_haha;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    public static List<test> questionsList = new ArrayList<>();

    public Questions(){
        quests();
    }

    public static List<test> quests () {
        final test question1 = new test("В 1952 году президентом какой страны был предложен Альберт Эйнштейн?",
                "Израиль", "Чили", "Австралия", "Германия", "Израиль");
        final test question2 = new test("Валюта Дании?",
                "Евро", "Крона", "Доллар", "Юань", "Крона");
        final test question3 = new test("Сколько элементов в периодической таблице Менделеева?",
                "118", "72", "109", "86", "118");
        final test question4 = new test("Сколько часовых поясов в России?",
                "1", "3", "11", "7", "11");
        final test question5 = new test("Кто считается основоположником современного русского языка?",
                "А. С. Пушкин", "М. В. Ломоносов", "М. Ю. Лермонтов", "М. А. Булгаков", "А. С. Пушкин");
        final test question6 = new test("Первый россиянин, удостоенный Нобелевской премии по литературе?",
                "Б. Пастернак", "В. Набоков", "братья Стругацкие", "И. Бунин", "И. Бунин");
        final test question7 = new test("Где сидел Шалтай-Болтай перед тем, как упал?",
                "На холме", "На полу", "На стене", "На стуле", "На стене");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);

        return questionsList;
    }
}

