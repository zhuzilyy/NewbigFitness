package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.animator;

import android.animation.ValueAnimator;

import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.horizontalexpcalendar.listener.SmallAnimationListener;


/**
 * Created by MikeSu on 18/08/16.
 * www.michalsulek.pl
 */
public class CalendarAnimation extends ValueAnimator {

  public void setListener(SmallAnimationListener smallAnimationListener) {
    addUpdateListener(smallAnimationListener);
    addListener(smallAnimationListener);
    start();
  }
}
