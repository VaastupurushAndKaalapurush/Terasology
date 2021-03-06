/*
 * Copyright 2020 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.persistence.typeHandling.mathTypes;

import gnu.trove.list.TIntList;
import org.joml.Vector2i;
import org.terasology.persistence.typeHandling.PersistedData;
import org.terasology.persistence.typeHandling.PersistedDataArray;
import org.terasology.persistence.typeHandling.PersistedDataSerializer;

import java.util.Optional;

/**
 */
public class Vector2iTypeHandler extends org.terasology.persistence.typeHandling.TypeHandler<Vector2i> {

    @Override
    public PersistedData serializeNonNull(Vector2i value, PersistedDataSerializer serializer) {
        return serializer.serialize(value.x, value.y);
    }

    @Override
    public Optional<Vector2i> deserialize(PersistedData data) {
        if (data.isArray()) {
            PersistedDataArray dataArray = data.getAsArray();
            if (dataArray.isNumberArray() && dataArray.size() > 1) {
                TIntList ints = dataArray.getAsIntegerArray();
                return Optional.of(new Vector2i(ints.get(0), ints.get(1)));
            }
        }
        return Optional.empty();
    }
}
