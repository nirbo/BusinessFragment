package org.nirbo.businessfragment.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import org.nirbo.businessfragment.R;

public class CircleButton extends ImageView {

    private int mCenterY;
    private int mCenterX;
    private int mOuterRadius;
    private Paint mCirclePaint;

    public CircleButton(Context context) {
        super(context);
        init(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, mOuterRadius, mCirclePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        mCenterX = width / 2;
        mCenterY = height / 2;
        mOuterRadius = Math.min(width, height) / 2;
    }

    public void setColor(int color) {
        mCirclePaint.setColor(color);
        this.invalidate();
    }

    private void init(Context context, AttributeSet attrs) {
        this.setFocusable(true);
        this.setScaleType(ScaleType.CENTER_INSIDE);
        setClickable(true);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);

        int color = Color.BLACK;
        if (attrs != null) {
            final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
            color = typedArray.getColor(R.styleable.CircleButton_button_color, color);
            typedArray.recycle();
        }

        setColor(color);
    }

}
