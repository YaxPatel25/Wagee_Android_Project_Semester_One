// Generated by view binder compiler. Do not edit!
package com.example.wagee_android_project_semester_one.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.example.wagee_android_project_semester_one.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  private ActivityMain2Binding(@NonNull CoordinatorLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ActivityMain2Binding((CoordinatorLayout) rootView);
  }
}
