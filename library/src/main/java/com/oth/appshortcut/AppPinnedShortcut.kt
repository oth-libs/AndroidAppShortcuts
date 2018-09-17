package com.oth.appshortcut

import android.app.PendingIntent
import android.content.Context
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build

object AppPinnedShortcut {

    fun addShortcut(context: Context?, shortcutConfig: ShortcutConfig) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        context?.let { ctx ->
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            if (shortcutManager.isRequestPinShortcutSupported) {
                val shortcut = ShortcutInfo.Builder(ctx, shortcutConfig.id).apply {
                    shortcutConfig.shortLabel?.let { setShortLabel(it) }
                    shortcutConfig.longLabel?.let { setLongLabel(it) }
                    shortcutConfig.icon?.let { setIcon(Icon.createWithResource(ctx, it)) }
                    shortcutConfig.intent?.let { setIntent(it) }
                }.build()


                var successCallback: PendingIntent? = null
                shortcutConfig.pinnedShortcutCallback?.let {
                    successCallback = PendingIntent.getBroadcast(context,
                            0,
                            it,
                            0)
                }

                shortcutManager.requestPinShortcut(shortcut, successCallback?.intentSender)
            }

        }
    }


}