package com.andrew.curvedmotionexercise;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;
    Transition transitionMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootContainer = (ViewGroup) findViewById(R.id.rootContainer);

        scene1 = Scene.getSceneForLayout(rootContainer, R.layout.scene1_layout, this);
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene2_layout, this);
        transitionMgr = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        scene1.enter();

    }
    public void goToScene2 (View view)
    {
        TransitionManager.go(scene2, transitionMgr);
    }

    public void goToScene1 (View view)
    {
        TransitionManager.go(scene1, transitionMgr);
    }
}