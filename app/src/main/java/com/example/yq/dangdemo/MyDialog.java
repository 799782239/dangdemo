package com.example.yq.dangdemo;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by yQ on 2016-06-10.
 */

public class MyDialog extends Dialog{
    public MyDialog(Context context) {
        super(context);
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

}
