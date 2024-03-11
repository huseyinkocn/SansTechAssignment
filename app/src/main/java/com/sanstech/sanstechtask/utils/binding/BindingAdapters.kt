package com.sanstech.sanstechtask.utils.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["loadImage", "placeHolder"], requireAll = false)
    fun loadImage(view: ImageView, url: String?, placeHolder: Drawable?) {
        Glide.with(view.context)
            .load(url)
            .placeholder(android.R.color.darker_gray)
            .apply(
                RequestOptions().transform(
                    MultiTransformation(
                        CenterCrop(),
                        RoundedCorners(5)
                    )
                )
            )
            .into(view)
    }
}
