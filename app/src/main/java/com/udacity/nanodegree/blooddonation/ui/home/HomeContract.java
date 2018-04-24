package com.udacity.nanodegree.blooddonation.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.google.android.gms.maps.model.LatLng;
import com.udacity.nanodegree.blooddonation.base.BasePresenter;

interface HomeContract {

    interface View {

        /**
         * Method to zoom camera to a particular location. If {@code position} is null the camera
         * must animate to the current location if it is available.
         *
         * @param position: Lat long to animate camera at.
         */
        void updateCamera(@Nullable LatLng position);

        /**
         * Method to pass general information to the activity in order to show general response
         * message.
         *
         * @param msg: Message to be displayed
         */
        void generalInfo(@StringRes int msg);

        /**
         * Method to switch to a particular activity.
         *
         * @param activity
         * @param requestCode
         * @param bundle
         */
        void switchActivity(Class activity, int requestCode, @Nullable Bundle bundle);
    }

    interface Presenter extends BasePresenter {

        /**
         * Action to perform on pressing add button.
         */
        void onAddClicked();

        /**
         * Action to perform on current location click.
         */
        void onCurrentLocationClicked();

        /**
         * Method to handle onActivityResult.
         *
         * @param requestCode
         * @param resultCode
         * @param data
         */
        void handleActivityResult(int requestCode, int resultCode, Intent data);

    }

}
