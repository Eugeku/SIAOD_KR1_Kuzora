package sample;

import java.io.Serializable;

/**
 * Created by Eugene13 on 12.12.2016.
 * Class List:
 * 1) Класс реализует методы добавления элемента в конец,
 * извлечение элемента из хвоста, считываение элемента из хвоста,
 * проверка на наличие элементов в листе;
 * 2) Данный список реализован как очередь LIFO(стек);
 */
class List<E> implements Serializable {
    private ListElement<E> head;
    private ListElement<E> tail;

    //put element in tail
    void addInTail(ListElement<E> element) {
        if (tail == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }

    //take and delete element from tail
    E takeElement() {
        E pet;
        ListElement<E> ret = null;
//If list is empty
        if (head == null) return null;
//If list contains only 1 element
        if (head == tail) {
            ret = head;
            head = null;
            tail = null;
            pet = ret.getSomeValue();
            return pet;
        }
//Go to last element and take it
        ListElement<E> listElement = head;
        while (listElement.next != tail) {
            listElement = listElement.next;
        }
        tail = listElement;
        ret = listElement.next;
        listElement.next = null;
        pet = ret.getSomeValue();
        return pet;
    }

    //    readTailElement
    E readTailElement() {
        E pet;
        ListElement<E> ret = null;
//If list is empty
        if (head == null) return null;
//If list contains only 1 element
        if (head == tail) {
            ret = head;
            pet = ret.getSomeValue();
            return pet;
        }
//Go to last element and take it
        ListElement<E> listElement = head;
        while (listElement.next != tail) {
            listElement = listElement.next;
        }
        ret = listElement.next;
        pet = ret.getSomeValue();
        return pet;
    }

    boolean hasListElements() {
        return (head != null);
    }
}
