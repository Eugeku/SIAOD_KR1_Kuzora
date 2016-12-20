package sample;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene13 on 12.12.2016.
 * Class Translator:
 * 1) Класс производит перевод запись арифиметического из инфиксного вида в обратную польскую;
 * 2) Класс реализует метод перевода в обратную польскую запись (translate);
 * 3) Логика перевода построена на хранении и извлечении из стека, в зависимости от приоритета символов;
 */
class Translator {
    private char[] characters;
    private List<Character> characterList = new List<Character>();
    private String string = "";
    private Set<Character> charactersPriority0 = new HashSet<>();
    private Set<Character> charactersPriority1 = new HashSet<>();
    private Set<Character> charactersPriority2 = new HashSet<>();
    private Set<Character> charactersPriority3 = new HashSet<>();
    private Set<Character> charactersPriority4 = new HashSet<>();
    private Set<Character> charactersPriority5 = new HashSet<>();
    private Set<Character> charactersPriority6 = new HashSet<>();
    private Set<Character> charactersPriority7 = new HashSet<>();
    private Set<Character> charactersPriority8 = new HashSet<>();

    Translator(char[] characters) {
        this.characters = characters;
        charactersPriority0.add('(');
        charactersPriority1.add('=');
        charactersPriority1.add(')');
        charactersPriority7.add('+');
        charactersPriority7.add('-');
        charactersPriority8.add('/');
        charactersPriority8.add('*');
        charactersPriority8.add((char) 95);
        charactersPriority8.add((char) 94);
    }

    String translate() {
        for (char c : characters) {
            if (getPriority(c) == -1) string += c;
            else if (((getPriority(c) == 0) || getPriority(c) > getPriority(characterList.readTailElement())) & (c != ')')) {
                characterList.addInTail(new ListElement<>(c));
            } else if (getPriority(c) <= getPriority(characterList.readTailElement()) & (c != ')')) {
                do {
                    string += characterList.takeElement();
                } while (getPriority(c) < getPriority(characterList.readTailElement()));
                characterList.addInTail(new ListElement<>(c));
            } else if (c == ')') {
                while (characterList.readTailElement() != '(') {
                    string += characterList.takeElement();
                }
                characterList.takeElement();
            }
        }
        while (characterList.hasListElements()) {
            string += characterList.takeElement();
        }
        return string;
    }

    private int getPriority(Character c) {
        if (charactersPriority8.contains(c)) return 8;
        else if (charactersPriority7.contains(c)) return 7;
        else if (charactersPriority6.contains(c)) return 6;
        else if (charactersPriority1.contains(c)) return 1;
        else if (charactersPriority0.contains(c)) return 0;
        else return -1;
    }

}
