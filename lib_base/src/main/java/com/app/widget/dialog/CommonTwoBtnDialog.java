package com.app.widget.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * @date 2018-06-25
 * @Description:自定义dialog
 */
public class CommonTwoBtnDialog extends DialogFragment {

    private DialogInterface.OnClickListener positiveCallback;

    private String message;

    public static CommonTwoBtnDialog newInstance() {
        return new CommonTwoBtnDialog();
    }


    public void show(String message, FragmentManager fragmentManager, DialogInterface.OnClickListener positiveCallback) {
        this.message = message;
        this.positiveCallback = positiveCallback;
        show(fragmentManager, "ButtonDialogFragment");
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("提示");
        builder.setMessage(message);
        builder.setPositiveButton("确定", positiveCallback);
        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        return builder.create();

    }

}
