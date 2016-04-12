package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;

/**
 * TODO: document your custom view class.
 */
public class CompassView extends ImageView {
    private float degrees;

    public CompassView(Context context) {
        super(context);
        init(null, 0);
    }

    public CompassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CompassView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.CompassView, defStyle, 0);

        if (a.hasValue(R.styleable.CompassView_degrees)) {
            degrees = a.getFloat(R.styleable.CompassView_degrees, 0);
        }

        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int height = this.getHeight();
        int width = this.getWidth();

        canvas.rotate(degrees, width/2, height/2);
        super.onDraw(canvas);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.getText().add(String.valueOf(degrees));
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.
     *
     * @param degrees The direction in degrees
     */
    public void setDegrees(float degrees) {
        this.degrees = degrees;
    }
}
