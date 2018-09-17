package com.oth.appshortcut

import android.content.Intent
import android.support.annotation.DrawableRes

data class ShortcutConfig(val id: String,
                          val shortLabel: String? = null,
                          val longLabel: String? = null,
                          @DrawableRes val icon: Int? = null,
                          val intent: Intent? = null,
                          val pinnedShortcutCallback: Intent? = null)