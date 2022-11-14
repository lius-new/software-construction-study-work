package com.lius.work.backend.operation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComponentUseOperationData<T> implements Serializable {

    public static final long serialVersionUID = 24324234L;

    private List<T> data;
    private List<Boolean> answer = new ArrayList<Boolean>();
    private Integer exerciseCount;

    public ComponentUseOperationData() {
    }

    public ComponentUseOperationData(List<T> data) {
        this.data = data;
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public void setAnswerJudge(int index, String text) {
        OperationBase operationBase = (OperationBase) data.get(index);
        answer.add(index, (operationBase.getValue() + "").equals(text));
    }

    public Boolean getAnswerJudge(int index) {
        if (index >= answer.size()) return false;
        return answer.get(index);
    }

    public void cleanAnswer() {
        if (answer != null) answer.clear();
    }

    public void setExerciseCount(Integer exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public Integer getExerciseCount() {
        return exerciseCount;
    }
}
