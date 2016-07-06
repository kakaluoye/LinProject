package com.lin.prosessservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AIDLservice extends Service {
    public AIDLservice() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
