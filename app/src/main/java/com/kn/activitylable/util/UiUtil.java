package com.kn.activitylable.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;


/**
 * Author:kangna
 * Date: 2016/4/10  11:58
 * Email: kangna923@126.com
 * <pre>
 *     常用的一些方法：
 *     1.dp转换成px
 *     2.px转换成dp
 *     3.sp转换为px
 *     4.px转换为sp
 * </pre>
 */
public class UiUtil {
    /**
     * dp转换成px
     *
     * @param dp
     * @return
     */
    public static int dp2px(Context context, int dp) {
        return (int) (dp * getDensity(context) + 0.5f);
    }

    /**
     * px转换成dp
     *
     * @param px
     * @return
     */
    public static int px2dp(Context context, int px) {
        return (int) (px / getDensity(context) + 0.5f);
    }

    /**
     * sp转换为px
     *
     * @param sp
     * @return
     */
    public static int sp2px(Context context, float sp) {
        return (int) (sp * getDensity(context) + 0.5f);
    }

    /**
     * px转换成sp
     *
     * @param px
     * @return
     */
    public static int px2sp(Context context, float px) {
        return (int) (px / getDensity(context) + 0.5f);
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     * @return
     */
    public static int getDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int density = displayMetrics.densityDpi / 160;
        return density;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getHeight();
    }
}
