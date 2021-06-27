package com.app.notification.notification.services.impl;

import com.app.notification.notification.model.Device;
import com.app.notification.notification.model.UserDevice;
import com.app.notification.notification.services.DeviceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    int deviceId =1;
    int userDeviceId=1;
    List<Device> devicesList = new ArrayList<>();
    List <UserDevice> userDevices = new ArrayList<>();

    DeviceServiceImpl(){
        Device device = new Device();
        device.setId(this.deviceId++);
        device.setName("OnePLus5T");
        devicesList.add(device);
        UserDevice userDevice = new UserDevice();
        userDevice.setId(this.userDeviceId++);
        userDevice.setDeviceId(device.getId());
        userDevice.setUserId(1);
        this.userDevices.add(userDevice);

    }


    @Override
    public List<Device> createDevice(List<Device> devices, int userId) {

        List<Device> deviceListResponse = new ArrayList<>();
        devices.forEach(device -> {
            device.setId(this.deviceId++);
            this.devicesList.add(device);
            UserDevice userDevice = new UserDevice();
            userDevice.setId(this.userDeviceId++);
            userDevice.setDeviceId(device.getId());
            userDevice.setUserId(userId);
            this.userDevices.add(userDevice);

            deviceListResponse.add(device);

        });
        return deviceListResponse;
    }
    public List<Device> findDeviceByUserId( int userId) {
        List<Device> deviceListResponse = new ArrayList<>();
        List<UserDevice> userDeviceList = findUserDevicesByUserId(userId);
        userDeviceList.forEach(userDevice -> {
            this.devicesList.stream().filter(device -> device.getId()==userDevice.getDeviceId()).forEach(device -> deviceListResponse.add(device));
        });

        return deviceListResponse;
    }

    private List<UserDevice> findUserDevicesByUserId(int userId){
        return userDevices.stream().filter(userDevice -> userDevice.getUserId()==userId).collect(Collectors.toList());
    }





    }
