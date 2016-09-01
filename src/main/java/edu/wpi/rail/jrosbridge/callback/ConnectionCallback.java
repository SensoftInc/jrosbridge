package edu.wpi.rail.jrosbridge.callback;

import org.java_websocket.handshake.ServerHandshake;

/**
 * Created by Ant1Zykl0n on 29.08.2016.
 */
public interface ConnectionCallback {
    void onOpen(ServerHandshake handshakedata);
    void onClose(int code, String reason, boolean remote);
    void onError(Exception ex);
}
