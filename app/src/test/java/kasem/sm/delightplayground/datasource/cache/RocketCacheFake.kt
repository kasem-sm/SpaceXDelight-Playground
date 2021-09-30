/*
 Copyright (c) 2021 Kasem S.M.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package kasem.sm.delightplayground.datasource.cache

import kasem.sm.delightplayground.datasource.Rocket

class RocketCacheFake(
    private val db: RocketDatabaseFake
) : RocketCache {
    override suspend fun selectAll(): List<Rocket> {
        return db.rocket
    }

    override suspend fun selectRocketById(id: Int): Rocket? {
        return db.rocket.find {
            it.id.toInt() == id
        }
    }

    override suspend fun insertRocket(rocket: Rocket) {
        db.rocket.add(rocket)
    }

    override suspend fun insertRockets(rocket: List<Rocket>) {
        db.rocket.addAll(rocket)
    }
}
