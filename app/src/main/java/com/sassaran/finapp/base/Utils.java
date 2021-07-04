package com.sassaran.finapp.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.sassaran.finapp.R;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utils {

    private static ProgressDialog dialog;


    public static boolean isInternetAvailable(Context context) {

        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

        if (activeNetworkInfo != null) { // connected to the internet
            Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        return false;
    }


    public static void hideKeyboard(Activity activity) {

        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);

        }

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public static String generateUUID() {

        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;

    }

//    merchantCode=MERCHANT123|currencyType=INR|appCode=ET|pymtMode=Internet|txnDate=20150717|securityId=CRIS|RU=http://localhost:7001/eticketing/BankResponse|orderReference=1617607907563|txnAmount=23|checkSum=88499dff69219e405b2a86e79580ca8d3eae933637e58555b5431d4ff294107a




    /**
     * request exp : merchantCode=MERCHANT123|reservationId=100000274061812|txnAmount=458.00
     *
     * @param decrypt
     * @return
     */
    private LinkedHashMap<String, String> buildRequestParam(String decrypt) {
        // if decrypt null then return null
        if (decrypt == null) return null;
        // create LinkedHashMap object
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        // first delemeter is |
        String[] splitParam = decrypt.split("\\|");
        // loop the split Param
        for (String param : splitParam) {
            String[] keyValue = param.split("=");
            if (keyValue.length > 1) {
                params.put(keyValue[0], keyValue[1]);
            }
        }
        return params;
    }

    /**
     * @param params
     * @return
     */
    private String buildParam(LinkedHashMap<String, String> params) {
        // if empty or null param then return null
        if (params == null || params.isEmpty()) return null;
        // create String buffer for build request param
        StringBuffer paramBuilder = new StringBuffer();
        // build request param

        for (Map.Entry mapElements : params.entrySet()) {
            paramBuilder.append(mapElements.getKey());
            paramBuilder.append("=");
            paramBuilder.append(mapElements.getValue());
            paramBuilder.append("|");
        }
        // remove last pipe from paramBuilder and return
        return paramBuilder.toString().substring(0, paramBuilder.toString().length() - 1);
    }

    /**
     * AES/CBC/PKCS5PADDING
     *
     * @param value
     * @param key
     * @param initVector
     * @return
     */
    private String encrypt(String value, String key, String initVector) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
//            return Hex.encodeHexString(encrypted).toUpperCase();
            return byteArrayToHex(encrypted).toUpperCase();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }



    public static Dialog showProgressDialog(Context context) {

//        final AlertDialog progressDialog = new ProgressDialog(context);
        final Dialog progressDialog = new Dialog(context);
        final AlertDialog.Builder progressDialog1 = new AlertDialog.Builder(context);

        View progressView = LayoutInflater.from(context).inflate(R.layout.dialog_view, null);
        progressDialog.setContentView(progressView);

//        progressDialog.setMessage("Please Wait.....");

        progressDialog.setCancelable(true);

        if (!((Activity) context).isFinishing()) {

            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    progressDialog.show();

                }
            });
        }


        return progressDialog;
    }

    public static void dismissProgressDialog(Dialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    public void changeActivity(Context context,Class<Activity> newActivityClass,boolean isFinish){

        Intent intent = new Intent(context,newActivityClass);
        context.startActivity(intent);
        if (isFinish) {
            ((Activity)context).finish();
        }

    }



}
