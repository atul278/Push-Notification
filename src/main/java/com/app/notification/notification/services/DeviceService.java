package com.app.notification.notification.services;

import com.app.notification.notification.model.Device;

import java.util.List;

public interface DeviceService {
    public List<Device> createDevice(List<Device> device,int userId);
    public List<Device> findDeviceByUserId( int userId);

}
