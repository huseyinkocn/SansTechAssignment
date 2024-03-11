package com.sanstech.sanstechtask.utils.enums

import com.sanstech.sanstechtask.ui.currentContext
import com.sanstech.sanstechtask.R

enum class ToastMessageType(val layout: Int) {
    ERROR(R.layout.item_custom_toast_error),
    SUCCESS(R.layout.item_custom_toast_success),
    WARNING(R.layout.item_custom_toast_warning),
}

enum class InfoToastMessageType {
    ERROR,
    SUCCESS,
    WARNING,
    INFO
}

