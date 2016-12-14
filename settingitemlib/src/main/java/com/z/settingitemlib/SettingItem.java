package com.z.settingitemlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Miller Zhang  on 2016/12/9.
 * desc:
 * github:https://github.com/zxyaust  CSDN:http://blog.csdn.net/qq_31340657
 * Whatever happens tomorrow,we've had today.
 */

public class SettingItem extends LinearLayout {
    private Context mContext = getContext();
    //    左边textview
    public TextView leftText;
    private String leftTextString;
    private float leftTextSize = sp2px(16);//单位是sp
    private int leftTextColor = getResources().getColor(R.color.gray3);//默认333灰色
    //左边的imageview
    public ImageView leftImage;
    private int leftImageDrawableId;
    private int leftImageWidth = dip2px(25);
    private int leftImageHeight = leftImageWidth;
    private int leftImageMarginRight = dip2px(5);
    //右边的imageview
    public ImageView rightImage;
    private int rightImageDrawableId;
    private int rightImageWidth = dip2px(25);
    private int rightImageHeight = rightImageWidth;
    private int rightImageMarginLeft = dip2px(5);
    //因为刚开始获取自定义属性值都是px值,所以我们先把初始值转为px值

    //右边text
    public TextView rightText;
    private String rightTextString;
    private float rightTextSize = sp2px(14);
    private int rightTextColor = getResources().getColor(R.color.gray6);
    //tag
    public TextView tag;
    private String tagString;
    private boolean tagVisible = true;
    private boolean showDot = false;
    private int dotSize = dip2px(6);
    private int dotColor = getResources().getColor(R.color.red1);
    private float tagTextSize = sp2px(12);
    private int tagTextColor = getResources().getColor(R.color.white);
    private int tagTextBg = getResources().getColor(R.color.red1);
    private int tagMarginRight = dip2px(5);
    private RelativeLayout.LayoutParams tagLayoutParams;


    public SettingItem(Context context) {
        this(context, null);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.setting_item, null);
        leftText = (TextView) inflate.findViewById(R.id.tv_left);
        rightText = (TextView) inflate.findViewById(R.id.tv_right);
        leftImage = (ImageView) inflate.findViewById(R.id.iv_left);
        rightImage = (ImageView) inflate.findViewById(R.id.iv_right);
        tag = (TextView) inflate.findViewById(R.id.tv_tag);
        addView(inflate);
        initAttrs(attrs);
        initView();
    }


    private float px2sp(float px) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return px / fontScale;
    }

    private int sp2px(float sp) {
        final float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    private int dip2px(float dp) {
        float density = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    private float px2dip(int px) {
        float density = mContext.getResources().getDisplayMetrics().density;
        return px / density;
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SettingItem);
        //左边text
        leftTextString = array.getString(R.styleable.SettingItem_left_text);
        leftTextSize = array.getDimension(R.styleable.SettingItem_left_text_size, leftTextSize);
        leftTextColor = array.getColor(R.styleable.SettingItem_left_text_color, this.leftTextColor);

        //左边imageview
        leftImageDrawableId = array.getResourceId(R.styleable.SettingItem_left_image, leftImageDrawableId);
        leftImageWidth = array.getDimensionPixelOffset(R.styleable.SettingItem_left_image_width, leftImageWidth);
        leftImageHeight = array.getDimensionPixelOffset(R.styleable.SettingItem_left_image_height, leftImageHeight);
        leftImageMarginRight = array.getDimensionPixelOffset(R.styleable.SettingItem_left_image_marginRight, leftImageMarginRight);

        //右边text
        rightTextString = array.getString(R.styleable.SettingItem_right_text);
        rightTextSize = array.getDimension(R.styleable.SettingItem_right_text_size, rightTextSize);
        rightTextColor = array.getColor(R.styleable.SettingItem_right_text_color, rightTextColor);

        //右边imageview
        rightImageDrawableId = array.getResourceId(R.styleable.SettingItem_right_image, rightImageDrawableId);
        rightImageWidth = array.getDimensionPixelOffset(R.styleable.SettingItem_right_image_width, rightImageWidth);
        rightImageHeight = array.getDimensionPixelOffset(R.styleable.SettingItem_right_image_height, rightImageHeight);
        rightImageMarginLeft = array.getDimensionPixelOffset(R.styleable.SettingItem_right_image_marginLeft, rightImageMarginLeft);
        //tag
        tagString = array.getString(R.styleable.SettingItem_tag_text);
        tagVisible = array.getBoolean(R.styleable.SettingItem_tag_text_visible, tagVisible);
        showDot = array.getBoolean(R.styleable.SettingItem_show_dot, showDot);
        dotSize = array.getDimensionPixelSize(R.styleable.SettingItem_dotSize, dotSize);
        dotColor = array.getColor(R.styleable.SettingItem_dotColor, dotColor);
        tagTextSize = array.getDimension(R.styleable.SettingItem_tag_text_size, tagTextSize);
        tagTextColor = array.getColor(R.styleable.SettingItem_tag_text_color, tagTextColor);
        tagTextBg = array.getColor(R.styleable.SettingItem_tag_text_bg_color, tagTextBg);
        tagMarginRight = array.getDimensionPixelOffset(R.styleable.SettingItem_tag_text_marginRight, tagMarginRight);
        array.recycle();
    }

    private void initView() {
        leftText.setText(leftTextString);
        leftText.setTextColor(leftTextColor);
        leftText.setTextSize(px2sp(leftTextSize));
//
        leftImage.setImageResource(leftImageDrawableId);
        RelativeLayout.LayoutParams leftImageParams = (RelativeLayout.LayoutParams) leftImage.getLayoutParams();
        leftImageParams.width = leftImageWidth;
        leftImageParams.height = leftImageHeight;
        leftImageParams.rightMargin = leftImageMarginRight;
        leftImage.setLayoutParams(leftImageParams);
//
        rightText.setText(rightTextString);
        rightText.setTextSize(px2sp(rightTextSize));//默认是18sp
        rightText.setTextColor(rightTextColor);
//
        rightImage.setImageResource(rightImageDrawableId);
        RelativeLayout.LayoutParams rightImageParams = (RelativeLayout.LayoutParams) rightImage.getLayoutParams();
        rightImageParams.width = rightImageWidth;
        rightImageParams.height = rightImageHeight;
        rightImageParams.leftMargin = rightImageMarginLeft;
        rightImage.setLayoutParams(rightImageParams);
        //

        tag.setTextColor(tagTextColor);
        setTagBg(tagTextBg);
        tagLayoutParams = (RelativeLayout.LayoutParams) tag.getLayoutParams();
        tagLayoutParams.rightMargin = tagMarginRight;
        tag.setLayoutParams(tagLayoutParams);
        tag.setVisibility(tagVisible ? VISIBLE : GONE);
        if (showDot)//如果显示dot,就显示,否则不显示
            showDot();
        else {
            tag.setText(tagString);
            tag.setTextSize(px2sp(tagTextSize));
        }
    }

    public void setTagText(String s) {
        tag.setVisibility(VISIBLE);
        tag.setText(s);
        setTagBg(tagTextBg);
        tag.setTextSize(px2sp(tagTextSize));
        tagLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        tagLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        tag.setLayoutParams(tagLayoutParams);
        tag.setPadding(dip2px(4), 0, dip2px(4), 0);
    }

    public void removeTagAndDot() {
        tag.setVisibility(GONE);
    }

    public void showDot() {
        tag.setVisibility(VISIBLE);
        tag.setText("");
        setTagBg(dotColor);
        tagLayoutParams.height = dotSize;
        tagLayoutParams.width = dotSize;
        tag.setLayoutParams(tagLayoutParams);
    }

    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }

    public void setDotColor(int dotColor) {
        this.dotColor = dotColor;
    }

    public void setTagBg(int color) {
        GradientDrawable background = (GradientDrawable) tag.getBackground();
        background.setColor(color);
        tag.setBackgroundDrawable(background);
    }

}
