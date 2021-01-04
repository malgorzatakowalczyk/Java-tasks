package server;

import java.util.Collection;
import java.util.HashMap;

import common.Action;

public class CollectData {

    private HashMap<String, Action> sockets = null;
    private String actualTime = null;
    private HashMap<String, String> appointments = null;

    public CollectData() {
        sockets = new HashMap<String, Action>();
        appointments = new HashMap<String, String>();
    }

    public void addClient(String client, Action controller) {
        sockets.put(client, controller);
    }

    public void removeClient(String client) {
        sockets.remove(client);
    }

    public void addAppointment(String client, String time) {
        appointments.put(client, time);
    }

    public void cancelAppointment(String client) {
        appointments.remove(client);
    }

    public HashMap<String, String> getAppointments() {
        return appointments;
    }

    public Collection<Action> getActions() {
        return sockets.values();
    }

    public String getAcutualTime() {
        return actualTime;
    }

}
