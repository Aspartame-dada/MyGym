package com.example.myloginactivity.Adapter;

import androidx.annotation.IntDef;

public class Type {
    @IntDef({
            GOODS,
            APPARATUS,
            LOST,
            TEACH_INFO,
            VIP
    })
    public @interface Near {};

    public static final int GOODS=1;
    public static final int APPARATUS=2;
    public static final int LOST=3;
    public static final int TEACH_INFO=4;
    public static final int VIP =5;
}
