package com.tocgic.exam.study_java_basic.week14;

import java.util.List;

public class TypeErasure {

    interface MyList {
        //int sort(List<String> lists); //'sort(List<String>)' clashes with 'sort(List)'; both methods have same erasure
        int sort(List lists);
    }

}
