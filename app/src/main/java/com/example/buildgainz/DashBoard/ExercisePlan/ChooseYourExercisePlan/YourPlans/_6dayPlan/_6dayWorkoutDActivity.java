package com.example.buildgainz.DashBoard.ExercisePlan.ChooseYourExercisePlan.YourPlans._6dayPlan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buildgainz.DashBoard.ExercisePlan.ChooseYourExercisePlan.YourPlans.WorkoutItem;
import com.example.buildgainz.DashBoard.ExercisePlan.ChooseYourExercisePlan.YourPlans.WorkoutViewActivity;
import com.example.buildgainz.DashBoard.ExercisePlan.ChooseYourExercisePlan.YourPlans.WorkoutsAdapter;
import com.example.buildgainz.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _6dayWorkoutDActivity extends AppCompatActivity implements WorkoutsAdapter.OnItemClickListener {
    List < WorkoutItem > workoutItemList;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_6day_workout_dactivity );
        Toolbar toolbar = findViewById ( R.id.toolbarWorkout6D );
        setSupportActionBar ( toolbar );
        Objects.requireNonNull ( getSupportActionBar ( ) ).setDisplayHomeAsUpEnabled ( true );

        workoutItemList = new ArrayList <> ( );

        workoutItemList.add(new WorkoutItem("exercises_img/Standing_Military_Press/","1.webp", "Standing Military Press", "4 sets of 8-12 reps"));
        workoutItemList.add(new WorkoutItem("exercises_img/Incline_Dumbbell_Press/","1.webp", "Incline Dumbbell Press", "3 sets of 8-12 reps"));
        workoutItemList.add(new WorkoutItem("exercises_img/Dumbbell_Flyes/","1.webp", "Dumbbell Flyes", "3 sets of 8-12 reps"));
        workoutItemList.add(new WorkoutItem("exercises_img/Standing_Dumbbell_Upright_Row/","1.webp", "Standing Dumbbell Upright Row", "4 sets of 8-12 reps"));
        workoutItemList.add(new WorkoutItem("exercises_img/Side_Lateral_Raise/","1.webp", "Side Lateral Raise", "3 sets of 8-12 reps"));
        workoutItemList.add(new WorkoutItem("exercises_img/Dips_-_Triceps_Version/","1.webp", "Dips - Triceps Version", "3 sets of 8-12 reps"));

        RecyclerView recyclerView = findViewById ( R.id.recyclerWorkout6D );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        WorkoutsAdapter workoutAdapter = new WorkoutsAdapter ( workoutItemList , this );
        recyclerView.setAdapter ( workoutAdapter );
    }


    @Override
    public void onItemClick ( int position ) {
        WorkoutItem selectedWorkout = workoutItemList.get(position);

        String instruction = "Workout Routine\n" +
                "\n" +
                "1. Warm-up:\n" +
                "\n" +
                "Do 1 or 2 set of low weight for warming up for blood flow in body parts.\n" +"\n" +
                "2. Exercise Sets (1-4):\n" +
                "\n" +
                "Perform 8-12 reps with proper form.\n" +
                "Rest 60-90 seconds between sets.\n" +
                "Repeat for required sets as said in upper.";
        Intent intent = new Intent ( _6dayWorkoutDActivity.this , WorkoutViewActivity.class );
        intent.putExtra("workoutName", selectedWorkout.getName());
        intent.putExtra("workoutImagePath", selectedWorkout.getImagePath());
        intent.putExtra("reps", selectedWorkout.getRepsSets ());
        intent.putExtra("instruction", instruction);


        startActivity ( intent );
    }

    //Back Button
    @Override
    public boolean onOptionsItemSelected ( @NonNull MenuItem item ) {
        if (item.getItemId ( ) == android.R.id.home) {
            onBackPressed ( ); // This will emulate the behavior of the back button
            return true;
        }
        return super.onOptionsItemSelected ( item );
    }

    @Override
    public void onPointerCaptureChanged ( boolean hasCapture ) {
        super.onPointerCaptureChanged ( hasCapture );
    }
}