package com.oth.appshortcut.sample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PinnedShortcutSuccessBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Pinned shortcut created!!!", Toast.LENGTH_SHORT).show();
    }

}