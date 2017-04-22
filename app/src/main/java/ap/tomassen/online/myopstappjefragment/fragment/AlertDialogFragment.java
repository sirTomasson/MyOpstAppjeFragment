package ap.tomassen.online.myopstappjefragment.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import ap.tomassen.online.myopstappjefragment.MainActivity;


/**
 * Created by youri on 27-3-2017.
 */

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle b = getArguments();
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        if (b != null && b.containsKey(MainActivity.DIMENSION_HEIGHT)) {
            alertDialog.setTitle("Screen dimensions: ");
            float dpWidth = b.getFloat(MainActivity.DIMENSION_HEIGHT);
            float dpHeight = b.getFloat(MainActivity.DIMENSION_WIDTH);
            alertDialog.setMessage("    * width     :   " + dpWidth + "dp\n"
                    + "    * height    :   " + dpHeight + "dp");
        } else {
            alertDialog.setTitle("Alert!");
            alertDialog.setMessage("Here's some important information!");
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                });

        return alertDialog;
    }
}
