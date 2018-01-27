package com.tylersuehr.chips;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * Contains all the mutable properties for our {@link ChipsInputLayout}.
 *
 * @author Tyler Suehr
 * @version 1.0
 */
final class ChipOptions {
    /* Properties pertaining to ChipEditText */
    ColorStateList textColorHint;
    ColorStateList textColor;
    CharSequence hint;

    /* Properties pertaining to ChipView */
    Drawable mChipDeleteIcon;
    ColorStateList mChipDeleteIconColor;
    ColorStateList mChipBackgroundColor;
    ColorStateList mChipTextColor;
    boolean mShowAvatar = true;
    boolean mShowDetails = true;
    boolean mShowDelete = true;

    /* Properties pertaining to DetailedChipView */
    ColorStateList detailedChipDeleteIconColor;
    ColorStateList detailedChipBackgroundColor;
    ColorStateList detailedChipTextColor;

    /* Properties pertaining to FilterableRecyclerView */
    ColorStateList filterableListBackgroundColor;
    ColorStateList filterableListTextColor;
    float filterableListElevation;

    /* Properties pertaining to the ChipsInputLayout itself */
    Typeface typeface = Typeface.DEFAULT;
    boolean allowCustomChips = true;
    int maxRows;


    ChipOptions(Context c, AttributeSet attrs) {
        TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ChipsInputLayout);

        // Setup the properties for the ChipEditText
        this.textColorHint = a.getColorStateList(R.styleable.ChipsInputLayout_android_textColorHint);
        this.textColor = a.getColorStateList(R.styleable.ChipsInputLayout_android_textColor);
        this.hint = a.getString(R.styleable.ChipsInputLayout_android_hint);

        // Setup the properties for the ChipView
        this.mChipDeleteIconColor = a.getColorStateList(R.styleable.ChipsInputLayout_chipDeleteIconColor);
        this.mChipBackgroundColor = a.getColorStateList(R.styleable.ChipsInputLayout_chipBackgroundColor);
        this.mChipTextColor = a.getColorStateList(R.styleable.ChipsInputLayout_chipTextColor);
        this.mShowAvatar = a.getBoolean(R.styleable.ChipsInputLayout_chipHasAvatarIcon, true);
        this.mShowDetails = a.getBoolean(R.styleable.ChipsInputLayout_detailedChipsEnabled, true);
        this.mShowDelete = a.getBoolean(R.styleable.ChipsInputLayout_chipDeletable, true);
        this.mChipDeleteIcon = a.getDrawable(R.styleable.ChipsInputLayout_chipDeleteIcon);

        // Setup the properties for the DetailedChipView
        this.detailedChipDeleteIconColor = a.getColorStateList(R.styleable.ChipsInputLayout_detailedChipDeleteIconColor);
        this.detailedChipBackgroundColor = a.getColorStateList(R.styleable.ChipsInputLayout_chipBackgroundColor);
        this.detailedChipTextColor = a.getColorStateList(R.styleable.ChipsInputLayout_detailedChipTextColor);

        // Setup the properties for the FilterableRecyclerView
        this.filterableListBackgroundColor = a.getColorStateList(R.styleable.ChipsInputLayout_filterableListBackgroundColor);
        this.filterableListTextColor = a.getColorStateList(R.styleable.ChipsInputLayout_filterableListTextColor);
        this.filterableListElevation = a.getDimension(R.styleable.ChipsInputLayout_filterableListElevation, Utils.dp(2));

        // Setup the properties for the ChipsInput itself
        this.allowCustomChips = a.getBoolean(R.styleable.ChipsInputLayout_customChipsEnabled, true);
        this.maxRows = a.getInt(R.styleable.ChipsInputLayout_maxRows, 3);

        a.recycle();
    }
}