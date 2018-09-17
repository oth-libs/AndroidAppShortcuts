package com.oth.appshortcut

import android.content.Intent
import android.support.annotation.DrawableRes

data class ShortcutConfig(val id: String, val shortLabel: String, val longLabel: String, @DrawableRes val icon: Int, val intent: Intent)