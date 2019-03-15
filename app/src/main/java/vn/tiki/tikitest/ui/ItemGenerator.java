package vn.tiki.tikitest.ui;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import java.util.Random;

public class ItemGenerator {
    public static View randomItemView(View view) {
        Random rnd = new Random();
        GradientDrawable shape =  new GradientDrawable();
        shape.setCornerRadius(8);
        shape.setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(198), rnd.nextInt(198)));
        view.setBackground(shape);
        return view;
    }
}
