package com.oth.appshortcut.sample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oth.appshortcut.AppDynamicShortcut
import com.oth.appshortcut.AppPinnedShortcut
import com.oth.appshortcut.ShortcutConfig
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        google.setOnClickListener {

            val shortcutConfig = ShortcutConfig(id = "gID",
                    shortLabel = "google.com",
                    longLabel = "open google.com",
                    icon = R.drawable.ic_launcher,
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")))

            AppDynamicShortcut.addShortcut(this@MainActivity, shortcutConfig)
        }

        amazon.setOnClickListener {
            val shortcutConfig = ShortcutConfig(id = "gID",
                    shortLabel = "amazon.com",
                    longLabel = "open amazon.com",
                    icon = R.drawable.ic_launcher,
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/")))

            AppDynamicShortcut.updateShortcut(this@MainActivity, shortcutConfig)
        }

        remove.setOnClickListener {
            AppDynamicShortcut.removeShortcut(this@MainActivity, "gID")
        }

        //

        pinned.setOnClickListener {
            val shortcutConfig = ShortcutConfig(id = "pinnedID",
                    shortLabel = "youtube.com",
                    longLabel = "open youtube.com",
                    icon = R.drawable.ic_launcher,
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/")))

            AppPinnedShortcut.addShortcut(this@MainActivity, shortcutConfig)
        }

        pinnedCallback.setOnClickListener {
            val shortcutConfig = ShortcutConfig(id = "pinnedID2",
                    shortLabel = "google.de",
                    longLabel = "open google.de",
                    icon = R.drawable.ic_launcher,
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.de/")),
                    pinnedShortcutCallback = Intent(this@MainActivity, PinnedShortcutSuccessBroadcast::class.java))

            AppPinnedShortcut.addShortcut(this@MainActivity, shortcutConfig)
        }
    }
}
