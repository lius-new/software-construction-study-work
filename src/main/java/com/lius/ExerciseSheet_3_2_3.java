package com.lius;

public class ExerciseSheet_3_2_3 {

    private static final short COLUMN_NUMBER = 5;

    public void formattedDisplay(Exercise_3_2 ex, int columns) {
        //TODO: 打印算式

        int i = 0;
        while (ex.hasNext()) {
            i++;
            System.out.print(i + "." + ex.next().asString() + "\t");
            if ((i + 1) % columns == 0) System.out.println("\n");
        }
    }

    public void formattedDisplay(Exercise_3_2 ex) {
        formattedDisplay(ex, COLUMN_NUMBER);
    }

    public static void main(String[] args) {
        Exercise_3_2 exercise_3_2 = new Exercise_3_2();
        exercise_3_2.generateSubstractExercise(60);
        ExerciseSheet_3_2_3 exerciseSheet_3_2_3 = new ExerciseSheet_3_2_3();
        exerciseSheet_3_2_3.formattedDisplay(exercise_3_2);
    }
}
