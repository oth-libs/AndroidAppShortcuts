package com.oth.appshortcut

import android.content.Context
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import java.util.*

object AppDynamicShortcut {

    fun addShortcut(context: Context?, shortcutConfig: ShortcutConfig) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let { ctx ->
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            val shortcut = ShortcutInfo.Builder(ctx, shortcutConfig.id).apply {
                shortcutConfig.shortLabel?.let { setShortLabel(it) }
                shortcutConfig.longLabel?.let { setLongLabel(it) }
                shortcutConfig.icon?.let { setIcon(Icon.createWithResource(ctx, it)) }
                shortcutConfig.intent?.let { setIntent(it) }
            }.build()

            shortcutManager.addDynamicShortcuts(Arrays.asList(shortcut))
        }
    }

    fun addShortcuts(context: Context?, shortcuts: List<ShortcutConfig>) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        shortcuts.forEach { addShortcut(context, it) }
    }

    fun updateShortcut(context: Context?, shortcutConfig: ShortcutConfig) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return

        context?.let { ctx ->
            val shortcutManager = context.getSystemService<ShortcutManager>(ShortcutManager::class.java)

            val shortcut = ShortcutInfo.Builder(ctx, shortcutConfig.id).apply {
                shortcutConfig.shortLabel?.let { setShortLabel(it) }
                shortcutConfig.longLabel?.let { setLongLabel(it) }
                shortcutConfig.icon?.let { setIcon(Icon.createWithResource(ctx, it)) }
                shortcutConfig.intent?.let { setIntent(it) }
            }.build()

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