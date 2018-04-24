package com.udacity.nanodegree.blooddonation.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.udacity.nanodegree.blooddonation.R;
import com.udacity.nanodegree.blooddonation.base.BaseActivity;
import com.udacity.nanodegree.blooddonation.databinding.ActivityHomeBinding;

/**
 * Created by Ankush Grover(ankushgrover02@gmail.com) on 23/04/2018.
 */
public class HomeActivity extends BaseActivity implements OnMapReadyCallback, HomeContract.View, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private HomePresenter mPresenter;
    private LinearLayout mBottomSheet;
    private BottomSheetBehavior<LinearLayout> sheetBehavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        mPresenter = new HomePresenter(this);
        mBottomSheet = findViewById(R.id.bottom_sheet);
        ((ActivityHomeBinding) mBinding).setPresenter(mPresenter);

        sheetBehavior = BottomSheetBehavior.from(mBottomSheet);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragement_maps);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        updateCamera(null);

        // Sample Markers.

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(28.6315, 77.2167))
                .title("Donor")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.6315, 78.2167))
                .title("Blood Request")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_map_theme:
                Toast.makeText(this, "Map Theme", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_sign_out:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void updateCamera(@Nullable LatLng position) {


        if (position == null)
            position = new LatLng(28.6315, 77.2167); // This is hard coded default location. This will be changed by current location


        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(position, 8);
        mMap.animateCamera(location, 2000, null);


    }


    @Override
    public void generalInfo(int msg) {
        //todo Change implementation.
        Toast.makeText(this, "Fab clicked", Toast.LENGTH_SHORT).show();
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        toggleBottomSheet();
        if (marker.getTitle().equals("Donor")) {

        } else if (marker.getTitle().equals("Donor")) {

        }
        return false;
    }
}
