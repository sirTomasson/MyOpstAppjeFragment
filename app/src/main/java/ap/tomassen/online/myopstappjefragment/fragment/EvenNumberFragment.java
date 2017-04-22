package ap.tomassen.online.myopstappjefragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ap.tomassen.online.myopstappjefragment.MainActivity;
import ap.tomassen.online.myopstappjefragment.R;

/**
 * Created by youri on 27-3-2017.
 */

public class EvenNumberFragment extends Fragment {
    
    private static final String TAG = EvenNumberFragment.class.getSimpleName();

    public EvenNumberFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View rootView = inflater.inflate(R.layout.even_nmbr_fragment, container, false);

        //edit the view

        Bundle b = getArguments();

        if (b != null && b.containsKey(MainActivity.COUNT_BUNDLE)) {
            int count = b.getInt(MainActivity.COUNT_BUNDLE);
            TextView tv = (TextView) rootView.findViewById(R.id.even_nmbr_tv);
            tv.setText(count + "");
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }
}
