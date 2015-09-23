package it.jaschke.alexandria;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Utility {
    private static Toast sToast;

    public static void displayToast(Context context, String message) {
        if (sToast != null) {
            sToast.cancel();
        }

        sToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        sToast.show();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (!isConnected) {
            displayToast(context, context.getString(R.string.toast_no_network_connectivity));
        }

        return isConnected;

    }
}