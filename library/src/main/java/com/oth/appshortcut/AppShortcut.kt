package com.oth.appshortcut

import android.content.Context
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import java.util.*

object AppShortcut {

    fun addShortcut(context: Context?, shortcutConfig: ShortcutConfig) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let {
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            val shortcut = ShortcutInfo.Builder(it, shortcutConfig.id)
                    .setShortLabel(shortcutConfig.shortLabel)
                    .setLongLabel(shortcutConfig.longLabel)
                    .setIcon(Icon.createWithResource(context, shortcutConfig.icon))
                    .setIntent(shortcutConfig.intent)
                    .build()

            shortcutManager.addDynamicShortcuts(Arrays.asList(shortcut))
        }
    }

    fun addShortcuts(context: Context?, shortcuts: List<ShortcutConfig>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        shortcuts.forEach { addShortcut(context, it) }
    }

    fun updateShortcut(context: Context?, shortcutConfig: ShortcutConfig) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let {
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            val shortcut = ShortcutInfo.Builder(it, shortcutConfig.id)
                    .setShortLabel(shortcutConfig.shortLabel)
                    .setLongLabel(shortcutConfig.longLabel)
                    .setIcon(Icon.createWithResource(context, shortcutConfig.icon))
                    .setIntent(shortcutConfig.intent)
                    .build()

            shortcutManager.updateShortcuts(Arrays.asList(shortcut))
        }
    }

    fun updateShortcuts(context: Context?, shortcuts: List<ShortcutConfig>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        shortcuts.forEach { updateShortcut(context, it) }
    }


    fun removeShortcut(context: Context?, shortcutId: String) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let {
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            shortcutManager.removeDynamicShortcuts(Arrays.asList(shortcutId))
        }
    }

    fun removeShortcuts(context: Context?, shortcutIds: List<String>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let {
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            shortcutManager.removeDynamicShortcuts(shortcutIds)
        }
    }

    fun removeAllShortcuts(context: Context?) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let {
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            shortcutManager.removeAllDynamicShortcuts()
        }
    }


}