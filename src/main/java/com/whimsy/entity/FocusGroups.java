package com.whimsy.entity;

import java.util.Date;

public class FocusGroups extends FocusGroupsKey {
    private Date focusTime;

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
    }
}