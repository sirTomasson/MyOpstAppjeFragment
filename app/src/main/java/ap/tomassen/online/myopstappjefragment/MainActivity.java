package ap.tomassen.online.myopstappjefragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ap.tomassen.online.myopstappjefragment.fragment.AlertDialogFragment;
import ap.tomassen.online.myopstappjefragment.fragment.EvenNumberFragment;
import ap.tomassen.online.myopstappjefragment.fragment.OddNumberFragment;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    public static final String COUNT_BUNDLE = "count_bundle";
    public static final String TAG_COUNT_FRAGMENT = "fragment_tag";
    public static final String TAG_DIALOG_FRAGMENT = "dialog_fragment";
    public static final String DIMENSION_WIDTH = "dimensions_width";
    public static final String DIMENSION_HEIGHT = "dimensions_height";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swapFragment();

        Button countUppBtn = (Button) findViewById(R.id.count_upp_btn);
        countUppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                swapFragment();
            }
        });

        FloatingActionButton infoButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    public boolean isOdd(int count) {
        int modulo = count % 2;

        if (modulo != 0) {
            return true;
        }
        return false;
    }

    private void showDialog() {
        ScreenUtility screenUtility = new ScreenUtility(this);

        float dpWidth = screenUtility.getDpWidth();
        float dpHeight = screenUtility.getDpHeight();

        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        Bundle b = new Bundle();

        b.putFloat(DIMENSION_WIDTH, dpWidth);
        b.putFloat(DIMENSION_HEIGHT, dpHeight);

        dialogFragment.setArguments(b);
        dialogFragment.show(getFragmentManager(), TAG_DIALOG_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        count--;
    }

    public void removeFragment() {
        Fragment fragment = getFragmentManager()
                .findFragmentByTag(TAG_COUNT_FRAGMENT);

        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }


    public void swapFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Bundle b = new Bundle();
        b.putInt(COUNT_BUNDLE, count);

        Fragment numberFragment;

        if (isOdd(count)) {
            numberFragment = new OddNumberFragment();
        } else {
            numberFragment = new EvenNumberFragment();
        }
        numberFragment.setArguments(b);
        transaction
                .addToBackStack(null)
                .replace(R.id.my_fragment_container, numberFragment, TAG_COUNT_FRAGMENT)
                .commit();
    }
}
