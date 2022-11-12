package com.lius.work.backend.operation;

import java.util.ArrayList;
import java.util.List;

public class ComponentUseOperationData<T> {
    private List<T> data;
    private List<Boolean> answer = new ArrayList<Boolean>();

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
}
