/*
 * Copyright 2016 MovingBlocks
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
package org.terasology.processing.system;

import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.EventPriority;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.logic.characters.CharacterComponent;
import org.terasology.logic.inventory.InventoryComponent;
import org.terasology.logic.inventory.InventoryManager;
import org.terasology.logic.players.event.OnPlayerSpawnedEvent;
import org.terasology.registry.In;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
@RegisterSystem
public class ResetStartingInventorySystem extends BaseComponentSystem {
    @In
    private EntityManager entityManager;

    @In
    private InventoryManager manager;

    @In
    public EntityRef player;

    @ReceiveEvent(components = {InventoryComponent.class, CharacterComponent.class}, priority = EventPriority.PRIORITY_TRIVIAL)
    //@ReceiveEvent()
    public void resetStartingInventory(OnPlayerSpawnedEvent event, EntityRef character) {
        for (int i = 0; i < manager.getNumSlots(character); i++) {
            // TODO: Temporarily removed.
            //manager.removeItem(character, EntityRef.NULL, manager.getItemInSlot(character, i), true);
        }
    }
}
