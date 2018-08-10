/*
 * Copyright (C) 2016 Lucas Gilone
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package com.lucassaka.botonerags;

public class Sound {
    private final String mName;
    private final int mResourceId;
    private final int mButtonId;
    private final int groupId;

    public Sound(String name, int resourceId, int buttonId, int groupId) {
        this.mName = name;
        this.mResourceId = resourceId;
        this.mButtonId=buttonId;
        this.groupId = groupId;
    }

    public int getResourceId() {
        return mResourceId;
    }

    /*public void setResourceId(int resourceId) {
        this.mResourceId = resourceId;
    }*/

    public String getName() {
        return mName;
    }

    public int getButtonId() {
        return mButtonId;
    }

    public int getGroupId() { return groupId; }

    /*public void setName(String name) {
        this.mName = name;
    }*/

    @Override
    public String toString() {
        return mName;
    }
}
