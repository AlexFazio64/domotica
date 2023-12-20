package com.orion.domotica.device;

public class Device {
        private String deviceId;
        private String deviceName;
        private float param;
        private boolean status;
        private boolean isOnline;

        // Costruttore
        public Device(String deviceId, String deviceName, float param,  boolean status) {
            this.deviceId = deviceId;
            this.deviceName = deviceName;
            this.param = param;
            this.status = status;
        }

        // Metodo per ottenere i dettagli del dispositivo
        public String getDetails() {
            return "Device ID: " + deviceId + "\nDevice Name: " + deviceName + "\nStatus: " + (isOnline ? "Online" : "Offline");
        }


        // Metodo per eseguire un'operazione sul dispositivo
        public void performOperation(String operation) {
            // Eseguire l'operazione sul dispositivo (es. accendere, spegnere, etc.)
            System.out.println("Performing operation '" + operation + "' on device " + deviceName);
        }

        // Metodo per ottenere il device ID
        public String getDeviceId() {
            return deviceId;
        }

        // Metodo per ottenere il nome del dispositivo
        public String getDeviceName() {
            return deviceName;
        }

        // Metodo per ottenere il parametro del dispositivo
        public float getParam() {
            return param;
        }


        // Metodo per verificare lo stato del dispositivo
        public boolean checkStatus() {
            return status;
        }

}
