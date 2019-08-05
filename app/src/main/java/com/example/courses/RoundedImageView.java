package com.example.courses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

public class RoundedImageView extends android.support.v7.widget.AppCompatImageView {
    protected Paint paint = new Paint();
    private float rounding = 0.2f;
    private Paint paintClear = new Paint();
    private RectF areaRect = new RectF();

    public RoundedImageView(Context context) {
        super(context);

        init(context);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        init(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context);
    }

    private void init(Context context) {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);

        paintClear.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paintClear.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRoundedHole(canvas);
    }

    private void drawRoundedHole(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.saveLayer(0f, 0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            canvas.saveLayer(0f, 0f, canvas.getWidth(), canvas.getHeight(), null, 0);
        }

        canvas.drawPaint(paint);
        areaRect.set(new RectF(0f, 0f, getWidth(), getHeight()));
        float rx = rounding * 0.5f * getWidth();
        float ry = rounding * 0.5f * getHeight();
        canvas.drawRoundRect(areaRect, rx, ry, paintClear);
        canvas.restore();
    }
}