package com.udacity.nanodegree.blooddonation.ui.userdetail.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.udacity.nanodegree.blooddonation.storage.SharedPreferenceManager;
import com.udacity.nanodegree.blooddonation.ui.userdetail.UserDetailContract;
import com.udacity.nanodegree.blooddonation.ui.userdetail.model.UserDetail;
import timber.log.Timber;

/**
 * Created by riteshksingh on Apr, 2018
 */
public class UserDetailPresenter implements UserDetailContract.Presenter {

  private final UserDetailContract.View mView;
  private final FirebaseAuth mFirebaseAuth;
  private final SharedPreferenceManager mSharedPreferenceManager;

  public UserDetailPresenter(UserDetailContract.View view, FirebaseAuth firebaseAuth,
      SharedPreferenceManager sharedPreference) {
    mFirebaseAuth = firebaseAuth;
    mSharedPreferenceManager = sharedPreference;
    mView = view;
  }

  @Override public void onCreate() {

  }

  @Override public void onStart() {

  }

  @Override public void onStop() {

  }

  @Override public void onDestroy() {

  }

  @Override public void onCreateNowClick(UserDetail userDetail) {
    Timber.d(userDetail.firstName.get());
    Timber.d(userDetail.lastName.get());
    Timber.d(userDetail.email.get());
    Timber.d(String.valueOf(userDetail.isMale.get()));
    Timber.d(userDetail.bloodGroup.get());
  }

  @Override public void onDobButtonClick() {
      mView.showDatePickerDialog();
  }
}
