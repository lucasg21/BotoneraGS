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

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.renderscript.Type;

abstract class SoundGroupStore {
    public static SoundGroup[] getSoundGroups(Context context) {
        Resources res = context.getApplicationContext().getResources();

        TypedArray labels = res.obtainTypedArray(R.array.groupLabels);
        TypedArray ids = res.obtainTypedArray(R.array.groupIds);
        TypedArray buttonsIds = res.obtainTypedArray(R.array.groupButtonsIds);
        TypedArray groupPicturesIds = res.obtainTypedArray(R.array.groupPicturesIds);

        SoundGroup[] soundGroups = new SoundGroup[labels.length()];

        for (int i = 0; i < soundGroups.length; i++) {
            soundGroups[i] = new SoundGroup(labels.getString(i),
                                            groupPicturesIds .getResourceId(i, -1),
                                            buttonsIds.getInt(i,-1),
                                            ids.getInt(i, -1));
        }

        labels.recycle();
        ids.recycle();
        buttonsIds.recycle();
        groupPicturesIds.recycle();

        return soundGroups;
    }
}