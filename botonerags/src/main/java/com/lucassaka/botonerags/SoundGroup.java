package com.lucassaka.botonerags;


public class SoundGroup {
    private final String mName;
    private final int mResourceId;
    private final int mButtonId;
    private final int mGroupId;

    public SoundGroup(String name, int resourceId,int buttonId, int groupId) {
        this.mName = name;
        this.mResourceId = resourceId;
        this.mButtonId=buttonId;
        this.mGroupId = groupId;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public String getName() {
        return mName;
    }

    public int getButtonId() {
        return mButtonId;
    }

    public int getGroupId() { return mGroupId; }

    @Override
    public String toString() {
        return mName;
    }
}
