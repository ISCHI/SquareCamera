package com.desmond.squarecamera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class CameraActivity extends AppCompatActivity {

    public static final String TAG = CameraActivity.class.getSimpleName();
    public static final String ARG_OVERLAY_DRAWABLE_NAME = CameraFragment.ARG_OVERLAY_DRAWABLE_NAME;
    public static final String ARG_RETURN_DATA_IMMEDIATELY = CameraFragment.ARG_RETURN_DATA_IMMEDIATELY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.squarecamera__CameraFullScreenTheme);
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.squarecamera__activity_camera);

        if (savedInstanceState == null) {
            CameraFragment fragment = (CameraFragment) CameraFragment.newInstance();
            Bundle bundle = new Bundle();
            String overlayFromIntent = getIntent().getStringExtra(ARG_OVERLAY_DRAWABLE_NAME);
            bundle.putString(ARG_OVERLAY_DRAWABLE_NAME, overlayFromIntent);
            boolean returnDataImmediatelyFromIntent = getIntent().getBooleanExtra(ARG_RETURN_DATA_IMMEDIATELY, false);
            bundle.putBoolean(ARG_RETURN_DATA_IMMEDIATELY, returnDataImmediatelyFromIntent);
            fragment.setArguments(bundle);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, CameraFragment.TAG)
                    .commit();
        }
    }

    public void returnPhotoUri(Uri uri) {
        Intent data = new Intent();
        data.setData(uri);

        if (getParent() == null) {
            setResult(RESULT_OK, data);
        } else {
            getParent().setResult(RESULT_OK, data);
        }

        finish();
    }

    public void onCancel(View view) {
        getSupportFragmentManager().popBackStack();
    }
}
