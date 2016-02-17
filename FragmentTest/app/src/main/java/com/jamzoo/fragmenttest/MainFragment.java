package com.jamzoo.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 測試Fragment
 *
 * @author Shannon Lo
 */
public class MainFragment extends Fragment {
    private static String BUNDLE_TITLE = "BUNDLE_TITLE";
    private static String BUNDLE_CONTAINER_TYPE = "BUNDLE_CONTAINER_TYPE";
    private int mTitleResId;
    private boolean mContainerType;

    public static MainFragment newInstance(int titleResId, boolean containerType) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_TITLE, titleResId);
        args.putBoolean(BUNDLE_CONTAINER_TYPE, containerType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mTitleResId = bundle.getInt(BUNDLE_TITLE);
            mContainerType = bundle.getBoolean(BUNDLE_CONTAINER_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        if (mContainerType) {
            // 這個寫法在加入fragment時會有UI問題，應避免填入root為null
            view = inflater.inflate(R.layout.fragment_main, null);
        } else {
            view = inflater.inflate(R.layout.fragment_main, container, false);
        }
        TextView text = (TextView) view.findViewById(R.id.tv_title);
        if (mTitleResId != 0) {
            text.setText(mTitleResId);
        }
        return view;
    }
}
