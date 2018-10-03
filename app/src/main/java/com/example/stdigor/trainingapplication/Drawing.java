package com.example.stdigor.trainingapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Drawing extends View {

    public Drawing(Context context){
        super(context);
    }

    public Drawing(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Drawing(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private boolean allow = false;

    Paint paint = new Paint();
    private final float x0  = super.getX();
    private final float y0  = super.getY();

    private float x         = x0 + 30f;
    private float y         = y0 + 30f;
    private boolean sidex   = true;
    private boolean sidey   = true;

    public void allowToMove(){
        allow = true;
    }

    public void notAllowToMove(){
        allow = false;
    }

    private void move(){
        if (allow) {
            if (sidex && x <= this.getWidth() - 15) {
                x += 2f;
            } else if (!sidex && x >= x0 + 10) {
                x += -2f;
            } else if (sidex && x > this.getWidth() - 15) {
                sidex = false;
                x += -2f;
            } else if (!sidex && x < x0 + 10) {
                sidex = true;
                x += 2f;
            }
            if (sidey && y <= this.getHeight() - 15) {
                y += 2f;
            } else if (!sidey && y >= y0 + 10) {
                y += -2f;
            } else if (sidey && y > this.getHeight() - 15) {
                sidey = false;
                y += -2f;
            } else if (!sidey && y < y0 + 10) {
                sidey = true;
                y += 2f;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, 20, paint);
        move();
        invalidate();
    }
}
