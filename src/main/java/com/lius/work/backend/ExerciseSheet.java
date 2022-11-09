package com.lius.work.backend;

public class ExerciseSheet {

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        exercise.generateBinaryExercise(20);
        System.out.println(exercise.getBinaryOperations());
    }
}
