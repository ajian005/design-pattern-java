package com.design.pattern.behavioral.observer.doc;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update();
}

interface Subject {
    public void attach(Observer obs);
    public void detach(Observer obs);
    public void Notify();
    public void setStatus(int status);
    public int getStatus();
}

class OfficeDoc implements Subject {
    private List<Observer> myObjs;
    private String mySubjectName;
    private int mStatus;
    public OfficeDoc(String name) {
        mySubjectName = name;
        this.myObjs = new ArrayList<Observer>();
        mStatus = 0;
    }

    @Override
    public void attach(Observer obs) {
        this.myObjs.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        this.myObjs.remove(obs);
    }

    @Override
    public void Notify() {
        for (Observer obs : this.myObjs) {
            obs.update();
        }
    }

    @Override
    public void setStatus(int status) {
        mStatus = status;
        System.out.println("SetStatus subject[" + mySubjectName + "]status:" + status);
    }

    @Override
    public int getStatus() {
        return mStatus;
    }
}

class DocExplorer implements Observer {
    private String myObsName;

    public DocExplorer(String name, Subject sub) {
        myObsName = name;
        sub.attach(this);
    }

    @Override
    public void update() {
        System.out.println("update observer[" + myObsName + "]");
    }
}

public class DocObserverTest {
    public static void main(String[] args) {
        Subject subjectA = new OfficeDoc("subject A");
        Observer observerA = new DocExplorer("observer A", subjectA);
        subjectA.setStatus(1);
        subjectA.Notify();
    }
}