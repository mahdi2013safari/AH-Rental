package com.example.mahdi.ah_rental.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;



/**
 * Created by Yousufi khan on 9/28/2017.
 */

public class CheckForConnection {
    private Context context;

    public CheckForConnection(Context context){
        this.context = context;
    }


    public boolean isInternetAvilable(){
        ConnectivityManager connec =(ConnectivityManager)this.context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||

                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {
            //Toast.makeText(context, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        }else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {
            //Toast.makeText(context, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }
    public boolean isWifiAvilable(){
        boolean isWifi = false;

        try {
            ConnectivityManager connec = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] infoNetAvilable = connec.getAllNetworkInfo();
            if(infoNetAvilable !=null){
                for(NetworkInfo networkInfo : infoNetAvilable){
                    if(networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
                        if(networkInfo.isConnected()&& networkInfo.isAvailable()){
                            isWifi = true;
                        }
                    }
                }
            }
        }catch (Exception e){}
        return isWifi;
    }
    public boolean isMobileDataAvilable(){
        boolean isMobile = false;
        ConnectivityManager connec =(ConnectivityManager)this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] infoNetAvilable = connec.getAllNetworkInfo();
        if(infoNetAvilable !=null){
            for(NetworkInfo networkInfo : infoNetAvilable){
                if(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                    if(networkInfo.isConnected()&& networkInfo.isAvailable()){
                        isMobile = true;
                    }
                }
            }
        }
        return isMobile;
    }
    public boolean isDataAvilable(){
        boolean isMobile = false,isWifi = false;
        ConnectivityManager connec =(ConnectivityManager)this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] infoNetAvilable = connec.getAllNetworkInfo();
        if(infoNetAvilable !=null){
            for(NetworkInfo networkInfo : infoNetAvilable){
                if(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                    if(networkInfo.isConnected()&& networkInfo.isAvailable()){
                        isMobile = true;
                    }
                }
                if(networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
                    if(networkInfo.isConnected()&& networkInfo.isAvailable()){
                        isWifi = true;
                    }
                }

            }
        }
        return isMobile || isWifi;
    }
    public boolean dataConnecting(){
        boolean isMobile = false,isWifi = false;
        ConnectivityManager connec =(ConnectivityManager)this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] infoNetAvilable = connec.getAllNetworkInfo();
        if(infoNetAvilable !=null){
            for(NetworkInfo networkInfo : infoNetAvilable){
                if(networkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                    if(networkInfo.isConnectedOrConnecting()){
                        isMobile = true;
                    }
                }
                if(networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
                    if(networkInfo.isConnectedOrConnecting()){
                        isWifi = true;
                    }
                }

            }
        }
        return isMobile || isWifi;
    }
  /*  public void showConnectionProblemDialog(){
        MaterialDialog.Builder alertDialog = new MaterialDialog.Builder(context);
        alertDialog.title(R.string.connection_alert_title)
                .contentColor(context.getResources().getColor(R.color.colorPrimary))
                .titleColor(context.getResources().getColor(R.color.colorPrimaryDark))
                .content(R.string.connection_problem)
                .positiveText(R.string.btn_ok)
                .icon(context.getResources().getDrawable(R.drawable.ic_disconnect_primary))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
*/


}
