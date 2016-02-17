package com.jamzoo.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.tv_container_null_open_fl).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_container_null_open_ll_v).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_container_null_open_ll_h).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_container_not_null_open_fl).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_container_not_null_open_ll_v).setOnClickListener(mOnClickListener);
        findViewById(R.id.tv_container_not_null_open_ll_h).setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
            Bundle bundle = new Bundle();

            switch (view.getId()) {
                case R.id.tv_container_null_open_fl:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_FL);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, true);
                    break;
                case R.id.tv_container_null_open_ll_v:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_LL_V);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, true);
                    break;
                case R.id.tv_container_null_open_ll_h:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_LL_H);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, true);
                    break;
                case R.id.tv_container_not_null_open_fl:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_FL);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, false);
                    break;
                case R.id.tv_container_not_null_open_ll_v:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_LL_V);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, false);
                    break;
                case R.id.tv_container_not_null_open_ll_h:
                    bundle.putInt(Constants.BUNDLE_TYPE, Constants.TYPE_LL_H);
                    bundle.putBoolean(Constants.BUNDLE_CONTAINER_TYPE, false);
                    break;
                default:
                    break;
            }

            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

}
