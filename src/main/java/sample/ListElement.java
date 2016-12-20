package sample;

import java.io.Serializable;

/**
 * Created by Eugene13 on 12.12.2016.
 * Class ListElement:
 * 1) Каждый элемент хранит ссылка на следующий элемент в поле next;
 */
class ListElement<E> implements Serializable {
    private E someValue;
    ListElement<E> next;

    //    default constructor
    private ListElement() {
        this.next = null;
        this.someValue = null;
    }

    //  user constructor
    ListElement(E someValue) {
        this();
        this.someValue = someValue;
    }

    E getSomeValue() {
        return this.someValue;
    }
}
