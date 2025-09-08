package com.tarhetbaman.ringtonepicker;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

@CapacitorPlugin(name = "RingtonePicker")
public class RingtonePickerPlugin extends Plugin {

    private static final int PICK_RINGTONE_REQUEST = 1001;
    private PluginCall savedCall;

    @PluginMethod
    public void pickRingtone(PluginCall call) {
        savedCall = call;
        Activity activity = getActivity();
        if (activity == null) {
            call.reject("Activity not available");
            return;
        }

        try {
            Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Notification Tone");
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);

            startActivityForResult(call, intent, PICK_RINGTONE_REQUEST);
        } catch (Exception e) {
            call.reject("Failed to open ringtone picker: " + e.getMessage());
        }
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_RINGTONE_REQUEST && savedCall != null) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                if (uri != null) {
                    JSObject ret = new JSObject();
                    ret.put("uri", uri.toString());
                    ret.put("title", getRingtoneTitle(uri));
                    savedCall.resolve(ret);
                } else {
                    savedCall.resolve(new JSObject()); // user canceled, return empty
                }
            } else {
                savedCall.resolve(new JSObject()); // canceled
            }
            savedCall = null;
        }
    }

    private String getRingtoneTitle(Uri uri) {
        RingtoneManager ringtoneManager = new RingtoneManager(getContext());
        ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION);
        Cursor cursor = ringtoneManager.getCursor();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(RingtoneManager.ID_COLUMN_INDEX);
                Uri itemUri = Uri.withAppendedPath(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), "" + id);
                if (itemUri.equals(uri)) {
                    return cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
                }
            }
        }
        return uri.getLastPathSegment();
    }
}
