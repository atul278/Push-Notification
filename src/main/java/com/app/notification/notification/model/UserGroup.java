package com.app.notification.notification.model;

import lombok.Data;

/**
 * Entity for User belonging to a particular group
 *
 * */
@Data
public class UserGroup {
    int id;
    int userId;
    int groupUserId;
}
