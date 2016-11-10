package com.kn.activitylable.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

import com.kn.activitylable.util.UiUtil;

/**
 * Author:kangna
 * Date: 2016/9/27 14:31
 * Email:kangna923@126.com
 * <pre>
 *     自定义ReplacementSpan，实现活动标签效果
 * </pre>
 */

public class RectSpan extends ReplacementSpan {
    private Paint mPaint;
    private Paint tPaint;
    private int mWidth;
    private int tWidth;
    private Context mContext;

    public RectSpan(Context context, int colorId) {
        this.mContext = context;
        //定义画笔，画标签的外层框框
        mPaint = new Paint();
        //定义画笔颜色，此处需要传入颜色的id
        mPaint.setColor(colorId);
        //设置画笔空心
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔的宽度
        mPaint.setStrokeWidth(UiUtil.getDensity(context) * 1);
        //消除画笔锯齿
        mPaint.setAntiAlias(true);
        //定义画笔，用来画传入的文字
        tPaint = new Paint();
        //定义文字画笔颜色
        tPaint.setColor(colorId);
        //消除锯齿
        tPaint.setAntiAlias(true);

    }

    @Override
    public int getSize(Paint paint, CharSequence charSequence, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
        //测量标签的宽度
        mWidth = (int) paint.measureText(charSequence, start, end);
        //设置标签内的文字的大小，这里将文字大小减小，是为了让标签和标题中的文字大小协调
        tPaint.setTextSize(paint.getTextSize() - UiUtil.sp2px(mContext, 4));
        //测量文字的实际宽度
        tWidth = (int) tPaint.measureText(charSequence, start, end);
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //定义矩形的大小
        RectF rectF = new RectF(x + UiUtil.sp2px(mContext, 4), top + UiUtil.sp2px(mContext, 4) / 2, x + mWidth + UiUtil.sp2px(mContext, 4), bottom - UiUtil.sp2px(mContext, 4) / 2);
        //绘制矩形，参数一：刚定义的矩形；参数二：x方向上圆角半径；参数三：y方向上的圆角半径；参数四：画笔
        canvas.drawRoundRect(rectF, 15, 15, mPaint);
        Paint.FontMetrics fontMetrics = tPaint.getFontMetrics();
        float top1 = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top  
        float bottom1 = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom  
        int baseLineY = (int) (rectF.centerY() - top1 / 2 - bottom1 / 2);//基线中间点的y轴计算公式  
        canvas.drawText(text.toString(), start, end, rectF.centerX() - tWidth / 2, baseLineY, tPaint);
    }
}
