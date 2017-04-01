package com.optimumnano.quickcharge.dialog;

import android.app.Activity;

import com.optimumnano.quickcharge.R;
import com.optimumnano.quickcharge.base.BaseDialog;


/**
 * Created by ds on 2017/1/16.
 *
 */
public class DefaultDialog extends BaseDialog {
    public DefaultDialog(Activity mAty) {
        super(mAty);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.dialog_default;
    }
}
