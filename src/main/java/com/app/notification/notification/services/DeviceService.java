package com.app.notification.notification.services;

import com.app.notification.notification.model.Device;

import java.util.List;

/**
 * DeviceService interface for device management
 *
 * */
public interface DeviceService {

    /**
     * Creates device and assign it to particular user
     * */
    public List<Device> createDevice(List<Device> device,int userId);

    /**
     * Finds all devices for a particular user
     * */
    public List<Device> findDeviceByUserId( int userId);

}
