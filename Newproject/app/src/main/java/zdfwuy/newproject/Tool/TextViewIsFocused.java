package zdfwuy.newproject.Tool;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by ASUS on 2021/3/5.
 */
public class TextViewIsFocused extends TextView {
    public TextViewIsFocused(Context context) {
        super(context);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

}
