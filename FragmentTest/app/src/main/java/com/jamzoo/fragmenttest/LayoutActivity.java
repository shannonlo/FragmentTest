package com.jamzoo.fragmenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Layout Activity
 *
 * @author Shannon Lo
 */
public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = 0, titleResId = 0;
        boolean containerType = false;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int type = bundle.getInt(Constants.BUNDLE_TYPE, Constants.TYPE_FL);
            if (type == Constants.TYPE_FL) {
                layoutId = R.layout.activity_fl;
                titleResId = R.string.open_fl;

            } else if (type == Constants.TYPE_LL_V) {
                layoutId = R.layout.activity_ll_v;
                titleResId = R.string.open_ll_v;

            } else if (type == Constants.TYPE_LL_H) {
                layoutId = R.layout.activity_ll_h;
                titleResId = R.string.open_ll_h;

            }

            containerType = bundle.getBoolean(Constants.BUNDLE_CONTAINER_TYPE);
        }

        if (layoutId != 0) {
            setContentView(layoutId);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(titleResId, containerType))
                    .commit();

        } else {
            this.finish();
        }

    }

}
